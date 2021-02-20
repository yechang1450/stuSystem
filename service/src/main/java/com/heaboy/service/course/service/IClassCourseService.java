package com.heaboy.service.course.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.course.entity.ClassCourse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface IClassCourseService extends IService<ClassCourse> {

    /**
    *
    * @param page
    * @param classCourse
    * @return
    */
    IPage<ClassCourse> index(Page<ClassCourse> page ,ClassCourse classCourse);

    ClassCourse getClassCourseByCourseNoAndClassNo(Long courseNo, String classNo);
}
