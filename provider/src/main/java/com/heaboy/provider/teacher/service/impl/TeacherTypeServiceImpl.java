package com.heaboy.provider.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.teacher.entity.TeacherType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.teacher.mapper.TeacherTypeMapper;
import com.heaboy.service.teacher.service.ITeacherTypeService;
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
public class TeacherTypeServiceImpl extends ServiceImpl<TeacherTypeMapper, TeacherType> implements ITeacherTypeService {

    @Override
    public IPage<TeacherType> index(Page<TeacherType> page ,TeacherType teacherType){

        QueryWrapper<TeacherType> queryWrapper = new QueryWrapper<TeacherType>();
        if(!ObjectUtils.isEmpty(teacherType.getTeacherTypeName())) {
            queryWrapper = queryWrapper.like("teacherTypeName",teacherType.getTeacherTypeName());
        }
        IPage<TeacherType> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
