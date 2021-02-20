package com.heaboy.provider.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.teaching.entity.Teaching;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.teaching.mapper.TeachingMapper;
import com.heaboy.service.teaching.service.ITeachingService;
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
public class TeachingServiceImpl extends ServiceImpl<TeachingMapper, Teaching> implements ITeachingService {

    @Override
    public IPage<Teaching> index(Page<Teaching> page ,Teaching teaching){

        QueryWrapper<Teaching> queryWrapper = new QueryWrapper<Teaching>();
        if(!ObjectUtils.isEmpty(teaching.getClassId())) {
            queryWrapper = queryWrapper.like("classId",teaching.getClassId());
        }
        if(!ObjectUtils.isEmpty(teaching.getSubjectId())) {
            queryWrapper = queryWrapper.like("subjectId",teaching.getSubjectId());
        }
        if(!ObjectUtils.isEmpty(teaching.getTeacherId())) {
            queryWrapper = queryWrapper.like("teacherId",teaching.getTeacherId());
        }
        if(!ObjectUtils.isEmpty(teaching.getModelId())) {
            queryWrapper = queryWrapper.like("modelId",teaching.getModelId());
        }
        if(!ObjectUtils.isEmpty(teaching.getTeacherTotalScore())) {
            queryWrapper = queryWrapper.like("teacherTotalScore",teaching.getTeacherTotalScore());
        }
        if(!ObjectUtils.isEmpty(teaching.getStatus())) {
            queryWrapper = queryWrapper.like("status",teaching.getStatus());
        }
        if(!ObjectUtils.isEmpty(teaching.getTeachingStartTime())) {
            queryWrapper = queryWrapper.like("teachingStartTime",teaching.getTeachingStartTime());
        }
        if(!ObjectUtils.isEmpty(teaching.getTeachingEndTime())) {
            queryWrapper = queryWrapper.like("teachingEndTime",teaching.getTeachingEndTime());
        }
        if(!ObjectUtils.isEmpty(teaching.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId",teaching.getCreatorId());
        }
        if(!ObjectUtils.isEmpty(teaching.getCreator())) {
            queryWrapper = queryWrapper.like("creator",teaching.getCreator());
        }
        IPage<Teaching> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
