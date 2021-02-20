package com.heaboy.provider.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.sys.entity.SysRole;
import com.heaboy.service.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.sys.mapper.SysUserMapper;
import com.heaboy.service.sys.entity.SysUserRoles;
import com.heaboy.service.sys.service.ISysUserRolesService;
import com.heaboy.service.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private ISysUserRolesService sysUserRolesService;
    @Override
    public IPage<SysUser> index(Page<SysUser> page ,SysUser sysUser){

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        if(!ObjectUtils.isEmpty(sysUser.getCreatetime())) {
            queryWrapper = queryWrapper.like("createtime",sysUser.getCreatetime());
        }
        if(!ObjectUtils.isEmpty(sysUser.getPassword())) {
            queryWrapper = queryWrapper.like("password",sysUser.getPassword());
        }
        if(!ObjectUtils.isEmpty(sysUser.getUpdatetime())) {
            queryWrapper = queryWrapper.like("updatetime",sysUser.getUpdatetime());
        }
        if(!ObjectUtils.isEmpty(sysUser.getUsername())) {
            queryWrapper = queryWrapper.like("username",sysUser.getUsername());
        }
        if(!ObjectUtils.isEmpty(sysUser.getAvailable())) {
            queryWrapper = queryWrapper.like("available",sysUser.getAvailable());
        }
        if(!ObjectUtils.isEmpty(sysUser.getEmail())) {
            queryWrapper = queryWrapper.like("email",sysUser.getEmail());
        }
        if(!ObjectUtils.isEmpty(sysUser.getTel())) {
            queryWrapper = queryWrapper.like("tel",sysUser.getTel());
        }
        if(!ObjectUtils.isEmpty(sysUser.getSexType())) {
            queryWrapper = queryWrapper.like("sex_type",sysUser.getSexType());
        }
        IPage<SysUser> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public SysUser findByUsername(String name) {
        return this.baseMapper.findByUsername(name);
    }

    @Transactional
    @Override
    public long register(SysUser user) {
        this.baseMapper.insertSelective(user);
        SysUserRoles sysUserRoles = new SysUserRoles();
        sysUserRoles.setSysUserId(user.getId());
        sysUserRoles.setRolesId(SysRole.CODE_BASE_ROLE);
        sysUserRolesService.save(sysUserRoles);
        return user.getId();
    }

    @Override
    public Boolean setFirstFalseById(long currentUserId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(currentUserId);
        sysUser.setFirst(false);
        return updateById(sysUser);
    }
}
