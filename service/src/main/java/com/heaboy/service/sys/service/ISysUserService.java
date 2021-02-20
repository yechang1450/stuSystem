package com.heaboy.service.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
public interface ISysUserService extends IService<SysUser> {

    /**
    *
    * @param page
    * @param sysUser
    * @return
    */
    IPage<SysUser> index(Page<SysUser> page ,SysUser sysUser);

    /**
     *
     * @param name
     * @return
     */
    SysUser findByUsername(String name);

    /**
     * 注册并返回主键
     * 注册时同时绑定基础权限
     * @param user
     * @return
     */
    long register(SysUser user);

    Boolean setFirstFalseById(long userId);
}
