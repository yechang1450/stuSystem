package com.heaboy.provider.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.course.entity.ClassCourse;
import com.heaboy.provider.course.mapper.ClassCourseMapper;
import com.heaboy.service.course.service.IClassCourseService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Service
public class ClassCourseServiceImpl extends ServiceImpl<ClassCourseMapper, ClassCourse> implements IClassCourseService {

    @Override
    public IPage<ClassCourse> index(Page<ClassCourse> page ,ClassCourse classCourse){

        QueryWrapper<ClassCourse> queryWrapper = new QueryWrapper<ClassCourse>();
        if(!ObjectUtils.isEmpty(classCourse.getClassNo())) {
            queryWrapper = queryWrapper.like("classNo",classCourse.getClassNo());
        }
        if(!ObjectUtils.isEmpty(classCourse.getTeacherNos())) {
            queryWrapper = queryWrapper.like("teacherNos",classCourse.getTeacherNos());
        }
        if(!ObjectUtils.isEmpty(classCourse.getCourseNo())) {
            queryWrapper = queryWrapper.like("courseNo",classCourse.getCourseNo());
        }
        if(!ObjectUtils.isEmpty(classCourse.getUsualWeight())) {
            queryWrapper = queryWrapper.like("usualWeight",classCourse.getUsualWeight());
        }
        if(!ObjectUtils.isEmpty(classCourse.getTestWeight())) {
            queryWrapper = queryWrapper.like("testWeight",classCourse.getTestWeight());
        }
        if(!ObjectUtils.isEmpty(classCourse.getClassHoursLeft())) {
            queryWrapper = queryWrapper.like("classHoursLeft",classCourse.getClassHoursLeft());
        }
        if(!ObjectUtils.isEmpty(classCourse.getStatus())) {
            queryWrapper = queryWrapper.like("status",classCourse.getStatus());
        }
        if(!ObjectUtils.isEmpty(classCourse.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",classCourse.getDeleteFlag());
        }
        IPage<ClassCourse> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    /**说明：根据课程号查询信息
     * @param courseNo 课程号
     * @param classNo
     * @return 课程号对应的课程信息
     * @author 王啸威
     */
    @Override
    public ClassCourse getClassCourseByCourseNoAndClassNo(Long courseNo, String classNo) {
        QueryWrapper<ClassCourse> queryWrapper = new QueryWrapper<ClassCourse>();
        queryWrapper = queryWrapper.eq("courseNo",courseNo);
        queryWrapper = queryWrapper.eq("classNo",classNo);
        return getBaseMapper().selectOne(queryWrapper);
    }
}
