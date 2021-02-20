package com.heaboy.provider.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.sys.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.sys.mapper.SysResourceMapper;
import com.heaboy.service.sys.service.ISysResourceService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

    @Override
    public IPage<SysResource> index(Page<SysResource> page ,SysResource sysResource){

        QueryWrapper<SysResource> queryWrapper = new QueryWrapper<SysResource>();
        if(!ObjectUtils.isEmpty(sysResource.getAvailable())) {
            queryWrapper = queryWrapper.like("available",sysResource.getAvailable());
        }
        if(!ObjectUtils.isEmpty(sysResource.getName())) {
            queryWrapper = queryWrapper.like("name",sysResource.getName());
        }
        if(!ObjectUtils.isEmpty(sysResource.getOrderNum())) {
            queryWrapper = queryWrapper.like("order_num",sysResource.getOrderNum());
        }
        if(!ObjectUtils.isEmpty(sysResource.getPermission())) {
            queryWrapper = queryWrapper.like("permission",sysResource.getPermission());
        }
        if(!ObjectUtils.isEmpty(sysResource.getType())) {
            queryWrapper = queryWrapper.like("type",sysResource.getType());
        }
        if(!ObjectUtils.isEmpty(sysResource.getUrl())) {
            queryWrapper = queryWrapper.like("url",sysResource.getUrl());
        }
        if(!ObjectUtils.isEmpty(sysResource.getParentId())) {
            queryWrapper = queryWrapper.like("parent_id",sysResource.getParentId());
        }
        IPage<SysResource> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public List<SysResource> selectByUsername(String username) {
        return this.baseMapper.selectByUsername(username);
    }
    @Override
    public List<SysResource> selectResourceByRoleId(Long roleId){
        return this.baseMapper.selectResourceByRoleId(roleId);
    }

    @Override
    public List<SysResource> loadMenus() {
        return this.baseMapper.loadMenus();
    }

    @Override
    public IPage<SysResource> listPage(SysResource sysResource, IPage<SysResource> page) {
        return this.baseMapper.listPage( page,sysResource);
    }

    @Override
    public List<SysResource> selectAll() {
        return this.baseMapper.selectAll();
    }

    @Override
    public List<SysResource> listByParentId(Long[] ids) {
        QueryWrapper<SysResource> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("parent_id", ids);
        return  list(queryWrapper);
    }

    @Override
    public List<SysResource> findByParentId(long parentId) {
        QueryWrapper<SysResource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        return list(queryWrapper);
    }
}
