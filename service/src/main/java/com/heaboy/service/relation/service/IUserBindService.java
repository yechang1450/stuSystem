package com.heaboy.service.relation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.relation.entity.UserBind;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.service.student.entity.Student;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-04
 */
public interface IUserBindService extends IService<UserBind> {

    /**
    *
    * @param page
    * @param userBind
    * @return
    */
    IPage<UserBind> index(Page<UserBind> page ,UserBind userBind);

    UserBind findOneBySysUserId(long sysUserId);

    UserBind bindStudent(long currentUserId, Student student);
}
