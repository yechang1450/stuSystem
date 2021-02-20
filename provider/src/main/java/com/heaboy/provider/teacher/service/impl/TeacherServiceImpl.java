package com.heaboy.provider.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.teacher.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.teacher.mapper.TeacherMapper;
import com.heaboy.service.teacher.service.ITeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Override
    public IPage<Teacher> index(Page<Teacher> page ,Teacher teacher){

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<Teacher>();
        if(!ObjectUtils.isEmpty(teacher.getTeacherNo())) {
            queryWrapper = queryWrapper.like("teacherNo",teacher.getTeacherNo());
        }
        if(!ObjectUtils.isEmpty(teacher.getTeacherName())) {
            queryWrapper = queryWrapper.like("teacherName",teacher.getTeacherName());
        }
        if(!ObjectUtils.isEmpty(teacher.getHeadFlag())) {
            queryWrapper = queryWrapper.like("headFlag",teacher.getHeadFlag());
        }
        if(!ObjectUtils.isEmpty(teacher.getSex())) {
            queryWrapper = queryWrapper.like("sex",teacher.getSex());
        }
        if(!ObjectUtils.isEmpty(teacher.getTeacherTypeID())) {
            queryWrapper = queryWrapper.like("teacherTypeID",teacher.getTeacherTypeID());
        }
        if(!ObjectUtils.isEmpty(teacher.getHonor())) {
            queryWrapper = queryWrapper.like("honor",teacher.getHonor());
        }
        if(!ObjectUtils.isEmpty(teacher.getStatus())) {
            queryWrapper = queryWrapper.like("status",teacher.getStatus());
        }
        if(!ObjectUtils.isEmpty(teacher.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",teacher.getDeleteFlag());
        }
        IPage<Teacher> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
