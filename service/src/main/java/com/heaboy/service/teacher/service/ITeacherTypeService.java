package com.heaboy.service.teacher.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teacher.entity.TeacherType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface ITeacherTypeService extends IService<TeacherType> {

    /**
    *
    * @param page
    * @param teacherType
    * @return
    */
    IPage<TeacherType> index(Page<TeacherType> page ,TeacherType teacherType);

}
