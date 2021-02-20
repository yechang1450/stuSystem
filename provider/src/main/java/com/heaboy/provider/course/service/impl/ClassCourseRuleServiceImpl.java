package com.heaboy.provider.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.course.entity.ClassCourseRule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.course.mapper.ClassCourseRuleMapper;
import com.heaboy.service.course.entity.ClassNameVo;
import com.heaboy.service.course.service.IClassCourseRuleService;
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
public class ClassCourseRuleServiceImpl extends ServiceImpl<ClassCourseRuleMapper, ClassCourseRule> implements IClassCourseRuleService {

    @Override
    public IPage<ClassCourseRule> index(Page<ClassCourseRule> page ,ClassCourseRule classCourseRule){

        QueryWrapper<ClassCourseRule> queryWrapper = new QueryWrapper<ClassCourseRule>();
        if(!ObjectUtils.isEmpty(classCourseRule.getClassCourseId())) {
            queryWrapper = queryWrapper.like("classCourseId",classCourseRule.getClassCourseId());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getStartTime())) {
            queryWrapper = queryWrapper.like("startTime",classCourseRule.getStartTime());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getEndTime())) {
            queryWrapper = queryWrapper.like("endTime",classCourseRule.getEndTime());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getSectionNum())) {
            queryWrapper = queryWrapper.like("sectionNum",classCourseRule.getSectionNum());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getWeekNum())) {
            queryWrapper = queryWrapper.like("weekNum",classCourseRule.getWeekNum());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getStatus())) {
            queryWrapper = queryWrapper.like("status",classCourseRule.getStatus());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",classCourseRule.getDeleteFlag());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId",classCourseRule.getCreatorId());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getClassNo())) {
            queryWrapper = queryWrapper.like("classNo",classCourseRule.getClassNo());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getTeachersNos())) {
            queryWrapper = queryWrapper.like("teachersNos",classCourseRule.getTeachersNos());
        }
        if(!ObjectUtils.isEmpty(classCourseRule.getCourseNo())) {
            queryWrapper = queryWrapper.like("courseNo",classCourseRule.getCourseNo());
        }
        IPage<ClassCourseRule> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public List<ClassNameVo> listCourseByClassNoAndUserName(String classNo, String userName) {
        return getBaseMapper().selectCourseByClassNoAndUserName(classNo,userName);
    }

    @Override
    public List<ClassNameVo> listCourseByUserName(String userName) {
        return getBaseMapper().selectCourseByUserName(userName);
    }
}
