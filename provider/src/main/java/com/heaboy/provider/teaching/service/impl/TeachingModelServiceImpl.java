package com.heaboy.provider.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.teaching.entity.TeachingModel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.teaching.mapper.TeachingModelMapper;
import com.heaboy.service.teaching.service.ITeachingModelService;
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
public class TeachingModelServiceImpl extends ServiceImpl<TeachingModelMapper, TeachingModel> implements ITeachingModelService {

    @Override
    public IPage<TeachingModel> index(Page<TeachingModel> page ,TeachingModel teachingModel){

        QueryWrapper<TeachingModel> queryWrapper = new QueryWrapper<TeachingModel>();
        if(!ObjectUtils.isEmpty(teachingModel.getModelName())) {
            queryWrapper = queryWrapper.like("modelName",teachingModel.getModelName());
        }
        if(!ObjectUtils.isEmpty(teachingModel.getState())) {
            queryWrapper = queryWrapper.like("state",teachingModel.getState());
        }
        if(!ObjectUtils.isEmpty(teachingModel.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId",teachingModel.getCreatorId());
        }
        if(!ObjectUtils.isEmpty(teachingModel.getCreater())) {
            queryWrapper = queryWrapper.like("creater",teachingModel.getCreater());
        }
        if(!ObjectUtils.isEmpty(teachingModel.getReviser())) {
            queryWrapper = queryWrapper.like("reviser",teachingModel.getReviser());
        }
        if(!ObjectUtils.isEmpty(teachingModel.getReviseTime())) {
            queryWrapper = queryWrapper.like("reviseTime",teachingModel.getReviseTime());
        }
        if(!ObjectUtils.isEmpty(teachingModel.getUsegeCount())) {
            queryWrapper = queryWrapper.like("usegeCount",teachingModel.getUsegeCount());
        }
        IPage<TeachingModel> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
