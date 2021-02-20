package com.heaboy.provider.sys.mapper;

import com.heaboy.service.sys.entity.SysUserRoles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
public interface SysUserRolesMapper extends BaseMapper<SysUserRoles> {

    int deleteUserRolesByUserId(@Param("sysUserId") Long userId);
}
