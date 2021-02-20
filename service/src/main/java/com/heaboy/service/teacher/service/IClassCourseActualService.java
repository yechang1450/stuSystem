package com.heaboy.service.teacher.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teacher.entity.ClassCourseActual;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.service.teacher.entity.ClassCourseActualVo;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-02
 */
public interface IClassCourseActualService extends IService<ClassCourseActual> {

    /**
    *
    * @param page
    * @param classCourseActual
    * @return
    */
    IPage<ClassCourseActual> index(Page<ClassCourseActual> page ,ClassCourseActual classCourseActual);

    IPage<ClassCourseActualVo> indexPage(Page<ClassCourseActualVo> page, ClassCourseActual courseActual, String userName);

}
