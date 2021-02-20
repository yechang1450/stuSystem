package com.heaboy.consumer.service;

import com.heaboy.consumer.domain.UserDetail;
import com.heaboy.service.sys.entity.SysResource;
import com.heaboy.service.sys.entity.SysUser;
import com.heaboy.service.sys.service.ISysResourceService;
import com.heaboy.service.sys.service.ISysUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 登录身份认证
 * @author: Wangzhen
 * createAt: 2020/5/29
 */
@Component("CustomUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Reference
    private ISysUserService sysUserService;

    @Reference
    private  ISysResourceService sysisResourceService;



    @Override
    public UserDetail loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.findByUsername(name);
        if (sysUser == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", name));
        }
        List<SysResource> resourceList = sysisResourceService.selectByUsername(sysUser.getUsername());
        UserDetail userDetail = new UserDetail(sysUser.getId(),sysUser.getUsername(), resourceList,
                sysUser.getPassword());
        userDetail.setFirst(sysUser.getFirst());
        return userDetail;
    }
}
