package com.heaboy.provider.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.teacher.entity.ClassCourseActual;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.teacher.mapper.ClassCourseActualMapper;
import com.heaboy.service.teacher.entity.ClassCourseActualVo;
import com.heaboy.service.teacher.service.IClassCourseActualService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-02
 */
@Service
public class ClassCourseActualServiceImpl extends ServiceImpl<ClassCourseActualMapper, ClassCourseActual> implements IClassCourseActualService {

    @Override
    public IPage<ClassCourseActual> index(Page<ClassCourseActual> page ,ClassCourseActual classCourseActual){

        QueryWrapper<ClassCourseActual> queryWrapper = new QueryWrapper<ClassCourseActual>();
        if(!ObjectUtils.isEmpty(classCourseActual.getTeacherNoActual())) {
            queryWrapper = queryWrapper.like("teacherNoActual",classCourseActual.getTeacherNoActual());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getClassCourseRulesId())) {
            queryWrapper = queryWrapper.like("classCourseRulesId",classCourseActual.getClassCourseRulesId());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getClassCourseId())) {
            queryWrapper = queryWrapper.like("classCourseId",classCourseActual.getClassCourseId());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getClassNo())) {
            queryWrapper = queryWrapper.like("classNo",classCourseActual.getClassNo());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getCourseNo())) {
            queryWrapper = queryWrapper.like("courseNo",classCourseActual.getCourseNo());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getStartTime())) {
            queryWrapper = queryWrapper.like("startTime",classCourseActual.getStartTime());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getEndTIme())) {
            queryWrapper = queryWrapper.like("endTIme",classCourseActual.getEndTIme());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getCourseContent())) {
            queryWrapper = queryWrapper.like("courseContent",classCourseActual.getCourseContent());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getPreview())) {
            queryWrapper = queryWrapper.like("preview",classCourseActual.getPreview());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getHomework())) {
            queryWrapper = queryWrapper.like("homework",classCourseActual.getHomework());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",classCourseActual.getDeleteFlag());
        }
        if(!ObjectUtils.isEmpty(classCourseActual.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId",classCourseActual.getCreatorId());
        }
        IPage<ClassCourseActual> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public IPage<ClassCourseActualVo> indexPage(Page<ClassCourseActualVo> page, ClassCourseActual courseActual, String userName) {
        return getBaseMapper().selectPageInfo(page,courseActual,userName);
    }
}
