package com.heaboy.provider.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.course.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.course.mapper.CourseMapper;
import com.heaboy.service.course.service.ICourseService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public IPage<Course> index(Page<Course> page ,Course course){

        QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
        if(!ObjectUtils.isEmpty(course.getCourseNo())) {
            queryWrapper = queryWrapper.like("courseNo",course.getCourseNo());
        }
        if(!ObjectUtils.isEmpty(course.getCourseName())) {
            queryWrapper = queryWrapper.like("courseName",course.getCourseName());
        }
        if(!ObjectUtils.isEmpty(course.getCredit())) {
            queryWrapper = queryWrapper.like("credit",course.getCredit());
        }
        if(!ObjectUtils.isEmpty(course.getClassHours())) {
            queryWrapper = queryWrapper.like("classHours",course.getClassHours());
        }
        if(!ObjectUtils.isEmpty(course.getIntroduction())) {
            queryWrapper = queryWrapper.like("introduction",course.getIntroduction());
        }
        if(!ObjectUtils.isEmpty(course.getCoursePurpose())) {
            queryWrapper = queryWrapper.like("coursePurpose",course.getCoursePurpose());
        }
        if(!ObjectUtils.isEmpty(course.getStatus())) {
            queryWrapper = queryWrapper.like("status",course.getStatus());
        }
        if(!ObjectUtils.isEmpty(course.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",course.getDeleteFlag());
        }
        IPage<Course> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
