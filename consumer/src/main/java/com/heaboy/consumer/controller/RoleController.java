package com.heaboy.consumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.service.sys.entity.SysResource;
import com.heaboy.service.sys.entity.SysRole;
import com.heaboy.service.sys.service.ISysResourceService;
import com.heaboy.service.sys.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.*;

/**
 * @author wangzhen
 * @title: RoleController
 * @projectName niua_easy_parent
 * @description: 获取权限角色控制类
 * @date 2020/11/28 下午2:59
 */
@RestController
@Api(value = "获取权限角色")
@ApiVersion(1)
@RequestMapping("/{version}/role")
public class RoleController {

    @Reference
    private ISysRoleService roleService;
    @Reference
    private ISysResourceService resourceService;

    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/list/{currentPage}/{pageSize}")
    public ResultJson index(@RequestBody SysRole role, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {

        IPage<SysRole> pageList = roleService.listPage(role, new Page<SysRole>(currentPage, pageSize));

        return ResultJson.ok(pageList);
    }

    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/loadResources/{id}")
    public ResultJson loadResources(@PathVariable Long id) {
        List<SysResource> resources = roleService.loadResourcesByRoleId(id);
        return ResultJson.ok(resources);
    }

    /**
     * 加载角色拥有的全部权限信息
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/selectResourceByRoleId/{id}")
    public ResultJson selectResourceByRoleId(@PathVariable Long id) {
        List<SysResource> resources = roleService.selectResourceByRoleId(id);
        return ResultJson.ok(resources);
    }

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/findRoleById/{id}")
    public ResultJson findRoleById(@PathVariable Long id) {
        SysRole role = roleService.getById(id);
        if(role != null){
            return ResultJson.ok(role);
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/saveOrUpdate")
    public ResultJson saveOrUpdate(@RequestBody SysRole role) {

        boolean flag = roleService.saveOrUpdate(role);
        if(flag){
            return ResultJson.ok();
        }

        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 更新角色权限
     * @param roleId
     * @param resourceIds
     * @return
     */
    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/updateRoleResources/{roleId}")
    public ResultJson updateRoleResources(@PathVariable Long roleId, @RequestBody Long[] resourceIds) {
        List list = new ArrayList();
        for(long resourceId : resourceIds){
           Map<String, Long> map = new HashMap<>();
           map.put("roleId", roleId);
           map.put("resourcesId", resourceId);
           list.add(map);
        }
        boolean flag = roleService.addRoleResourcesBatch(roleId, list);
        if(flag){
            return ResultJson.ok();
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 查询全部的资源信息
     * @return
     */
    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/loadAllResource")
    public ResultJson loadAllResource() {
        List<SysResource> resources = resourceService.selectAll();
        return ResultJson.ok(resources);
    }

    @PreAuthorize("hasAuthority('/role')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/delete")
    public ResultJson delete(@RequestParam Long[] ids) {

        boolean flag = roleService.deleteRoleById(Arrays.asList(ids));
        if(flag){
            return ResultJson.ok();
        }

        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }


}
