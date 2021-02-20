package com.heaboy.service.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.sys.entity.SysResource;
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
public interface ISysResourceService extends IService<SysResource> {

    /**
    *
    * @param page
    * @param sysResource
    * @return
    */
    IPage<SysResource> index(Page<SysResource> page ,SysResource sysResource);

    List<SysResource> selectByUsername(String username);

    /**
     * @Title: selectResourceByRoleId
     * @Description: 根据角色id查询资源信息
     * @Author: lxt
     * @param: roleId
     * @Date: 2019-06-10 15:49
     * @return: java.util.List<tech.niua.auth.domain.SysResource>
     * @throws:
     */
    List<SysResource> selectResourceByRoleId(Long roleId);

    /**
     * 加载菜单资源
     * @return
     */
    List<SysResource> loadMenus();

    /**
     * 分页查询资源信息
     * @param sysResource
     * @param page
     * @return
     */
    IPage<SysResource> listPage(SysResource sysResource, IPage<SysResource> page);

    /**
     * 查询全部资源信息
     * @return
     */
    List<SysResource> selectAll();

    List<SysResource> listByParentId(Long[] ids);

    List<SysResource> findByParentId(long parentId);
}
