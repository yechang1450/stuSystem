package com.heaboy.service.course.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.course.entity.ClassCourseRule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.service.course.entity.ClassNameVo;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface IClassCourseRuleService extends IService<ClassCourseRule> {

    /**
    *
    * @param page
    * @param classCourseRule
    * @return
    */
    IPage<ClassCourseRule> index(Page<ClassCourseRule> page ,ClassCourseRule classCourseRule);

    List<ClassNameVo> listCourseByClassNoAndUserName(String classNo, String userName);

    List<ClassNameVo> listCourseByUserName(String userName);
}
