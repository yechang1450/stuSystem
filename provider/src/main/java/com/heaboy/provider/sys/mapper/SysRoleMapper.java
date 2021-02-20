package com.heaboy.provider.sys.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heaboy.service.sys.entity.SysResource;
import com.heaboy.service.sys.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    int insertSelective(SysRole sysRole);

    /**
     * @Title: selectRolesByUserId
     * @Description: 根据用户id获取用户权限信息
     * @Author: lxt
     * @param: userId
     * @Date: 2019-06-10 11:12
     * @return: java.util.List<tech.niua.auth.domain.SysRole>
     * @throws:
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 根据角色id查询资源
     * @param roleId
     * @return
     */
    List<SysResource> selectResourceByRoleId(Long roleId);

    /**
     * @Title: listPage
     * @Description: 分页查询用户信息
     * @Author: lxt
     * @param: sysRole
     * @param: page
     * @Date: 2019-06-10 17:20
     * @return: java.util.List<tech.niua.auth.domain.SysRole>
     * @throws:
     */
    IPage<SysRole> listPage( IPage<SysRole> page,@Param("sysRole") SysRole sysRole);

    /**
     * 根据角色id组合权限
     * @param id
     * @return
     */
    List<SysResource> loadResourcesByRoleId(long id);

    /**
     * 删除角色和资源的绑定关系
     * @param id
     * @return
     */
    int deleteRefResourcesByRoleId(List<Long> id);

    /**
     * 批量插入角色和资源的绑定关系
     * @param list
     * @return
     */
    int insertRoleResourcesBatch(List list);
}
