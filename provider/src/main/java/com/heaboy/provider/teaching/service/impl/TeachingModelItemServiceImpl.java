package com.heaboy.provider.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.teaching.entity.TeachingModelItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.teaching.mapper.TeachingModelItemMapper;
import com.heaboy.service.teaching.service.ITeachingModelItemService;
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
public class TeachingModelItemServiceImpl extends ServiceImpl<TeachingModelItemMapper, TeachingModelItem> implements ITeachingModelItemService {

    @Override
    public IPage<TeachingModelItem> index(Page<TeachingModelItem> page ,TeachingModelItem teachingModelItem){

        QueryWrapper<TeachingModelItem> queryWrapper = new QueryWrapper<TeachingModelItem>();
        if(!ObjectUtils.isEmpty(teachingModelItem.getModelItemName())) {
            queryWrapper = queryWrapper.like("modelItemName",teachingModelItem.getModelItemName());
        }
        if(!ObjectUtils.isEmpty(teachingModelItem.getModelItemType())) {
            queryWrapper = queryWrapper.like("modelItemType",teachingModelItem.getModelItemType());
        }
        if(!ObjectUtils.isEmpty(teachingModelItem.getStatus())) {
            queryWrapper = queryWrapper.like("status",teachingModelItem.getStatus());
        }
        if(!ObjectUtils.isEmpty(teachingModelItem.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId",teachingModelItem.getCreatorId());
        }
        if(!ObjectUtils.isEmpty(teachingModelItem.getCreater())) {
            queryWrapper = queryWrapper.like("creater",teachingModelItem.getCreater());
        }
        if(!ObjectUtils.isEmpty(teachingModelItem.getReviser())) {
            queryWrapper = queryWrapper.like("reviser",teachingModelItem.getReviser());
        }
        if(!ObjectUtils.isEmpty(teachingModelItem.getReviseTime())) {
            queryWrapper = queryWrapper.like("reviseTime",teachingModelItem.getReviseTime());
        }
        if(!ObjectUtils.isEmpty(teachingModelItem.getUsageCount())) {
            queryWrapper = queryWrapper.like("usageCount",teachingModelItem.getUsageCount());
        }
        IPage<TeachingModelItem> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
