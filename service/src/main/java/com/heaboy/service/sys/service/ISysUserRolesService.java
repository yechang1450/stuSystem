package com.heaboy.service.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.sys.entity.SysUserRoles;
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
public interface ISysUserRolesService extends IService<SysUserRoles> {

    /**
    *
    * @param page
    * @param sysUserRoles
    * @return
    */
    IPage<SysUserRoles> index(Page<SysUserRoles> page ,SysUserRoles sysUserRoles);

    Boolean setStudentRoleByUserId(long currentUserId);

    List<SysUserRoles> loadUserRoleByUserId(long currentUserId);

    Boolean updateRoleByUserId(Long userId, Long[] userRoles);
}
