package com.heaboy.provider.sys.mapper;

import com.heaboy.service.sys.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUsername(String name);

    /**
     * 注册用户并返回主键
     * @param user
     * @return
     */
    long insertSelective(SysUser user);
}
