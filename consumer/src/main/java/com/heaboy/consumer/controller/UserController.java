package com.heaboy.consumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.sys.entity.SysRole;
import com.heaboy.service.sys.entity.SysUser;
import com.heaboy.service.sys.entity.SysUserRoles;
import com.heaboy.service.sys.service.ISysRoleService;
import com.heaboy.service.sys.service.ISysUserRolesService;
import com.heaboy.service.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangzhen
 * @title: UserController
 * @projectName niua_easy_parent
 * @description: 用户管理
 * @date 2020/11/30 下午9:48
 */
@Slf4j
@RestController
@Api(value = "用户管理")
@ApiVersion(1)
@RequestMapping("/{version}/user")
public class UserController {
    @Reference
    private ISysUserService userService;
    @Reference
    private ISysUserRolesService sysUserRolesService;
    @Reference
    private ISysRoleService sysRoleService;

    @PreAuthorize("hasAuthority('/user')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/list/{currentPage}/{pageSize}")
    public ResultJson index(@RequestBody SysUser user, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        IPage<SysUser> pageList = userService.index(new Page<>(currentPage, pageSize), user);

        return ResultJson.ok(pageList);
    }

    @PreAuthorize("hasAuthority('/user')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/findUserById/{id}")
    public ResultJson findUserById(@PathVariable Long id) {
        SysUser user = userService.getById(id);
        if(user != null){
            return ResultJson.ok(user);
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    @PreAuthorize("hasAuthority('/user')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/saveOrUpdate")
    public ResultJson saveOrUpdate(@RequestBody SysUser sysUser) {
        if(sysUser.getId()>0){
            sysUser.setUpdatetime(LocalDateTime.now());
        }
        boolean flag = userService.saveOrUpdate(sysUser);
        System.out.println("添加的用户信息:"+sysUser.toString());
        if(flag){
            return ResultJson.ok();
        }

        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    @PreAuthorize("hasAuthority('/user/delete-user')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/delete-user")
    public ResultJson delete(@RequestParam("ids") Long[] ids) {
        boolean flag = userService.removeByIds(Arrays.asList(ids));
        if(flag){
            return ResultJson.ok();
        }

        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    @PreAuthorize("hasAuthority('/user')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/loadUserRole/{userId}")
    public ResultJson loadUserRole( @PathVariable("userId")Long userId ) {
        List<SysUserRoles> sysUserRoles= sysUserRolesService.loadUserRoleByUserId(userId);
        List<SysRole> roleList = sysRoleService.list();
        HashMap<String, List> result = new HashMap<>();
        result.put("sysUserRoles",sysUserRoles);
        result.put("roleList",roleList);
        return ResultJson.ok(result);


    }
    @PreAuthorize("hasAuthority('/user')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/updateUserRole/{userId}")
    public ResultJson updateUserRole(@PathVariable("userId") Long userId,@RequestBody Long[] userRoles ) {
        Boolean save  = sysUserRolesService.updateRoleByUserId(userId,userRoles);
        return ResultJson.ok(save);


    }


}
