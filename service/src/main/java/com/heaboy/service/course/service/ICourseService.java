package com.heaboy.service.course.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.course.entity.Course;
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
public interface ICourseService extends IService<Course> {

    /**
    *
    * @param page
    * @param course
    * @return
    */
    IPage<Course> index(Page<Course> page ,Course course);

}
