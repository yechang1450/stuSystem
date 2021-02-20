package com.heaboy.consumer.service.impl;

import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.common.exception.CustomException;
import com.heaboy.consumer.domain.ResponseUserToken;

import com.heaboy.consumer.domain.UserDetail;
import com.heaboy.consumer.service.IAuthService;
import com.heaboy.consumer.utils.JwtUtils;
import com.heaboy.service.sys.entity.SysUser;
import com.heaboy.service.sys.service.ISysUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Reference
    private ISysUserService sysUserService;
    @Autowired
    private JwtUtils jwtUtils;

    @Qualifier("CustomUserDetailsService")
    private  UserDetailsService userDetailsService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Transactional
    @Override
    public Boolean register(SysUser sysUser) {
        final String username = sysUser.getUsername();
        if(sysUserService.findByUsername(username)!=null) {
            throw new CustomException(ResultJson.failure(ResultCode.BAD_REQUEST, "用户已存在"));
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = sysUser.getPassword();
        sysUser.setPassword(encoder.encode(rawPassword));
        sysUser.setAvailable(false);
        sysUser.setCreatetime(LocalDateTime.now());
        long save = sysUserService.register(sysUser);

        return save>0;
    }

    @Override
    public ResponseUserToken login(String username, String password) {
        //用户验证
        final Authentication authentication = authenticate(username, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        final UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        final String token = jwtUtils.generateAccessToken(userDetail);
        //存储token
        jwtUtils.putToken(username, token);
        return new ResponseUserToken(token, userDetail);

    }

    @Override
    public void logout(String token) {
        token = token.substring(tokenHead.length());
        String userName = jwtUtils.getUsernameFromToken(token);
        jwtUtils.deleteToken(userName);
    }

    @Override
    public ResponseUserToken refresh(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        String username = jwtUtils.getUsernameFromToken(token);
        UserDetail userDetail = (UserDetail) userDetailsService.loadUserByUsername(username);
        if (jwtUtils.canTokenBeRefreshed(token, userDetail.getLastPasswordResetDate())){
            token =  jwtUtils.refreshToken(token);
            return new ResponseUserToken(token, userDetail);
        }
        return null;
    }

    @Override
    public UserDetail getUserByToken(String token) {
        token = token.substring(tokenHead.length());
        return jwtUtils.getUserFromToken(token);
    }

    private Authentication authenticate(String username, String password) {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new CustomException(ResultJson.failure(ResultCode.LOGIN_ERROR, e.getMessage()));
        }
    }
}
