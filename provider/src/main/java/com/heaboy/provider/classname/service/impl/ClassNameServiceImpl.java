package com.heaboy.provider.classname.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.classname.entity.ClassName;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.classname.mapper.ClassNameMapper;
import com.heaboy.service.classname.service.IClassNameService;
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
public class ClassNameServiceImpl extends ServiceImpl<ClassNameMapper, ClassName> implements IClassNameService {

    @Override
    public IPage<ClassName> index(Page<ClassName> page ,ClassName className){

        QueryWrapper<ClassName> queryWrapper = new QueryWrapper<ClassName>();
        if(!ObjectUtils.isEmpty(className.getClassNo())) {
            queryWrapper = queryWrapper.like("classNo",className.getClassNo());
        }
        if(!ObjectUtils.isEmpty(className.getClassName())) {
            queryWrapper = queryWrapper.like("className",className.getClassName());
        }
        if(!ObjectUtils.isEmpty(className.getType())) {
            queryWrapper = queryWrapper.like("type",className.getType());
        }
        if(!ObjectUtils.isEmpty(className.getHeadTeacherId())) {
            queryWrapper = queryWrapper.like("headTeacherId",className.getHeadTeacherId());
        }
        if(!ObjectUtils.isEmpty(className.getHeadTeacherName())) {
            queryWrapper = queryWrapper.like("headTeacherName",className.getHeadTeacherName());
        }
        if(!ObjectUtils.isEmpty(className.getIsGraduation())) {
            queryWrapper = queryWrapper.like("isGraduation",className.getIsGraduation());
        }
        if(!ObjectUtils.isEmpty(className.getStageId())) {
            queryWrapper = queryWrapper.like("stageId",className.getStageId());
        }
        if(!ObjectUtils.isEmpty(className.getStudentNumber())) {
            queryWrapper = queryWrapper.like("studentNumber",className.getStudentNumber());
        }
        if(!ObjectUtils.isEmpty(className.getQqGroupNumber())) {
            queryWrapper = queryWrapper.like("qqGroupNumber",className.getQqGroupNumber());
        }
        if(!ObjectUtils.isEmpty(className.getQqGroup())) {
            queryWrapper = queryWrapper.like("qqGroup",className.getQqGroup());
        }
        if(!ObjectUtils.isEmpty(className.getWechatGroup())) {
            queryWrapper = queryWrapper.like("wechatGroup",className.getWechatGroup());
        }
        if(!ObjectUtils.isEmpty(className.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",className.getDeleteFlag());
        }
        if(!ObjectUtils.isEmpty(className.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId",className.getCreatorId());
        }
        if(!ObjectUtils.isEmpty(className.getCreater())) {
            queryWrapper = queryWrapper.like("creater",className.getCreater());
        }
        IPage<ClassName> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public List<ClassName> listByTeacherNo(String userName) {
        return getBaseMapper().selectByTeacherNo(userName);
    }
}
