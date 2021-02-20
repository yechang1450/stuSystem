package com.heaboy.provider.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.teaching.entity.TeachingModelRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.teaching.mapper.TeachingModelRelationMapper;
import com.heaboy.service.teaching.service.ITeachingModelRelationService;
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
public class TeachingModelRelationServiceImpl extends ServiceImpl<TeachingModelRelationMapper, TeachingModelRelation> implements ITeachingModelRelationService {

    @Override
    public IPage<TeachingModelRelation> index(Page<TeachingModelRelation> page ,TeachingModelRelation teachingModelRelation){

        QueryWrapper<TeachingModelRelation> queryWrapper = new QueryWrapper<TeachingModelRelation>();
        if(!ObjectUtils.isEmpty(teachingModelRelation.getModelId())) {
            queryWrapper = queryWrapper.like("modelId",teachingModelRelation.getModelId());
        }
        if(!ObjectUtils.isEmpty(teachingModelRelation.getModelOptionId())) {
            queryWrapper = queryWrapper.like("modelOptionId",teachingModelRelation.getModelOptionId());
        }
        if(!ObjectUtils.isEmpty(teachingModelRelation.getStatus())) {
            queryWrapper = queryWrapper.like("status",teachingModelRelation.getStatus());
        }
        if(!ObjectUtils.isEmpty(teachingModelRelation.getWeight())) {
            queryWrapper = queryWrapper.like("weight",teachingModelRelation.getWeight());
        }
        IPage<TeachingModelRelation> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
