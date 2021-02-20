package com.heaboy.provider.studentteaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.studentteaching.entity.StudentTeaching;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.studentteaching.mapper.StudentTeachingMapper;
import com.heaboy.service.studentteaching.service.IStudentTeachingService;
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
public class StudentTeachingServiceImpl extends ServiceImpl<StudentTeachingMapper, StudentTeaching> implements IStudentTeachingService {

    @Override
    public IPage<StudentTeaching> index(Page<StudentTeaching> page ,StudentTeaching studentTeaching){

        QueryWrapper<StudentTeaching> queryWrapper = new QueryWrapper<StudentTeaching>();
        if(!ObjectUtils.isEmpty(studentTeaching.getStudentNo())) {
            queryWrapper = queryWrapper.like("studentNo",studentTeaching.getStudentNo());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getTeachingId())) {
            queryWrapper = queryWrapper.like("teachingId",studentTeaching.getTeachingId());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getTeachingModelId())) {
            queryWrapper = queryWrapper.like("teachingModelId",studentTeaching.getTeachingModelId());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getTeachingFraction())) {
            queryWrapper = queryWrapper.like("teachingFraction",studentTeaching.getTeachingFraction());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getTeachingContent())) {
            queryWrapper = queryWrapper.like("teachingContent",studentTeaching.getTeachingContent());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getTeachingTime())) {
            queryWrapper = queryWrapper.like("teachingTime",studentTeaching.getTeachingTime());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getWhetherRead())) {
            queryWrapper = queryWrapper.like("whetherRead",studentTeaching.getWhetherRead());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getTeachingType())) {
            queryWrapper = queryWrapper.like("teachingType",studentTeaching.getTeachingType());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getSubjectId())) {
            queryWrapper = queryWrapper.like("subjectId",studentTeaching.getSubjectId());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getTeacherId())) {
            queryWrapper = queryWrapper.like("teacherId",studentTeaching.getTeacherId());
        }
        if(!ObjectUtils.isEmpty(studentTeaching.getClassId())) {
            queryWrapper = queryWrapper.like("classId",studentTeaching.getClassId());
        }
        IPage<StudentTeaching> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
