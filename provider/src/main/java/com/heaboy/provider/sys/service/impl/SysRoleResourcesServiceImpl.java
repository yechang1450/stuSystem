package com.heaboy.provider.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.sys.entity.SysRoleResources;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.sys.mapper.SysRoleResourcesMapper;
import com.heaboy.service.sys.service.ISysRoleResourcesService;
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
public class SysRoleResourcesServiceImpl extends ServiceImpl<SysRoleResourcesMapper, SysRoleResources> implements ISysRoleResourcesService {

    @Override
    public IPage<SysRoleResources> index(Page<SysRoleResources> page ,SysRoleResources sysRoleResources){

        QueryWrapper<SysRoleResources> queryWrapper = new QueryWrapper<SysRoleResources>();
        if(!ObjectUtils.isEmpty(sysRoleResources.getSysRoleId())) {
            queryWrapper = queryWrapper.like("sys_role_id",sysRoleResources.getSysRoleId());
        }
        if(!ObjectUtils.isEmpty(sysRoleResources.getResourcesId())) {
            queryWrapper = queryWrapper.like("resources_id",sysRoleResources.getResourcesId());
        }
        IPage<SysRoleResources> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
