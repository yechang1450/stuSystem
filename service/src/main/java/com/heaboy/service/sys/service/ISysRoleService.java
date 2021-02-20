package com.heaboy.service.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.sys.entity.SysResource;
import com.heaboy.service.sys.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
    *
    * @param page
    * @param sysRole
    * @return
    */
    IPage<SysRole> index(Page<SysRole> page ,SysRole sysRole);

    IPage<SysRole>  listPage(@Param("sysRole") SysRole sysRole, IPage<SysRole> page);
    /**
     * 根据角色id组合权限
     * @param id
     * @return
     */
    List<SysResource> loadResourcesByRoleId(long id);

    /**
     * 更新资源信息
     * @param roleId
     * @param list
     * @return
     */
    boolean addRoleResourcesBatch(long roleId, List list);

    /**
     * 根据角色id删除角色信息
     * @param roleIds
     * @return
     */
    boolean deleteRoleById(List<Long> roleIds);

    /**
     * 根据角色id查询资源
     * @param roleId
     * @return
     */
    List<SysResource> selectResourceByRoleId(Long roleId);
}
