package com.heaboy.consumer.controller;

import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.domain.ResponseUserToken;

import com.heaboy.consumer.service.IAuthService;
import com.heaboy.service.sys.entity.SysUser;
import com.heaboy.service.sys.service.ISysResourceService;
import com.heaboy.service.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author Wangzhen
 * createAt: 2020/5/29
 */
@RestController
@Api(value = "用户权限接口", tags = {"用户权限接口"})
@ApiVersion(1)
@RequestMapping("/{version}/auth")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;
//    @Reference
    @Autowired
    private IAuthService authService;
    @Reference
    private ISysUserService sysUserService;
    @Reference
    private ISysResourceService resourceService;





    @PostMapping(value = "/login")
    @ApiOperation(value = "登录", notes = "登录成功返回token,登录之前请先注册账号")
    public ResultJson<ResponseUserToken> login(
            @Valid @RequestBody SysUser user){
        final ResponseUserToken response = authService.login(user.getUsername(), user.getPassword());
        return ResultJson.ok(response);
    }


    @GetMapping(value = "/logout")
    @ApiOperation(value = "登出", notes = "退出登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    public ResultJson logout(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        authService.logout(token);
        return ResultJson.ok();
    }


    @PostMapping(value = "/sign")
    @ApiOperation(value = "用户注册")
    public ResultJson sign(@RequestBody SysUser user) {
        if (StringUtils.isAnyBlank(user.getUsername(), user.getPassword())) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }

        return ResultJson.ok(authService.register(user));
    }

}
