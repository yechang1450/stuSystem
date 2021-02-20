package com.heaboy.provider.relation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.relation.entity.UserBind;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.relation.mapper.UserBindMapper;
import com.heaboy.service.relation.service.IUserBindService;
import com.heaboy.service.student.entity.Student;
import com.heaboy.service.student.service.IStudentService;
import com.heaboy.service.sys.entity.SysRole;
import com.heaboy.service.sys.entity.SysUser;
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
 * @since 2021-02-04
 */
@Service
public class UserBindServiceImpl extends ServiceImpl<UserBindMapper, UserBind> implements IUserBindService {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRolesService userRolesService;
    @Override
    public IPage<UserBind> index(Page<UserBind> page ,UserBind userBind){

        QueryWrapper<UserBind> queryWrapper = new QueryWrapper<UserBind>();
        if(!ObjectUtils.isEmpty(userBind.getUserNo())) {
            queryWrapper = queryWrapper.like("userNo",userBind.getUserNo());
        }
        if(!ObjectUtils.isEmpty(userBind.getSysUserId())) {
            queryWrapper = queryWrapper.like("sysUserId",userBind.getSysUserId());
        }
        if(!ObjectUtils.isEmpty(userBind.getType())) {
            queryWrapper = queryWrapper.like("type",userBind.getType());
        }
        IPage<UserBind> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public UserBind findOneBySysUserId(long id) {
        QueryWrapper<UserBind> userBindQueryWrapper = new QueryWrapper<>();
        userBindQueryWrapper.eq("sysUserId", id);
        UserBind one = getOne(userBindQueryWrapper,false);
        return one;
    }

    @Override
    @Transactional
    public UserBind bindStudent(long currentUserId, Student student) {
         studentService.insertSelective(student);
        UserBind userBind = new UserBind();
        userBind.setSysUserId(currentUserId);
        userBind.setType(UserBind.CODE_STUDENT);
        userBind.setUserNo(student.getStudentNo());
        boolean save = save(userBind);

        if (save) {
            sysUserService.setFirstFalseById(currentUserId);
            userRolesService.setStudentRoleByUserId(currentUserId);
            return userBind;
        }
        return null;
    }
}
