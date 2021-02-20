package com.heaboy.provider.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.sys.entity.SysResource;
import com.heaboy.service.sys.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.sys.mapper.SysRoleMapper;
import com.heaboy.service.sys.service.ISysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;

import java.util.Arrays;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);
    @Autowired
    private SysRoleMapper roleMapper;
    @Override
    public IPage<SysRole> index(Page<SysRole> page ,SysRole sysRole){

        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>();
        if(!ObjectUtils.isEmpty(sysRole.getAvailable())) {
            queryWrapper = queryWrapper.like("available",sysRole.getAvailable());
        }
        if(!ObjectUtils.isEmpty(sysRole.getDescription())) {
            queryWrapper = queryWrapper.like("description",sysRole.getDescription());
        }
        if(!ObjectUtils.isEmpty(sysRole.getName())) {
            queryWrapper = queryWrapper.like("name",sysRole.getName());
        }
        IPage<SysRole> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public IPage<SysRole>  listPage(SysRole sysRole, IPage<SysRole> page) {
        return roleMapper.listPage( page,sysRole);
    }

    @Override
    public List<SysResource> loadResourcesByRoleId(long id) {
        return roleMapper.loadResourcesByRoleId(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addRoleResourcesBatch(long roleId, List list) {
        try {
            roleMapper.deleteRefResourcesByRoleId(Arrays.asList(new Long[]{roleId}));
            roleMapper.insertRoleResourcesBatch(list);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteRoleById(List<Long> roleIds) {
        try{
            roleMapper.deleteRefResourcesByRoleId(roleIds);
            roleMapper.deleteBatchIds(roleIds);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public List<SysResource> selectResourceByRoleId(Long roleId) {
        return roleMapper.selectResourceByRoleId(roleId);
    }

}
