package com.heaboy.provider.planitem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.provider.planitem.mapper.PlanItemMapper;
import com.heaboy.service.planitem.entity.PlanItem;
import com.heaboy.service.planitem.service.IPlanItemService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.util.ObjectUtils;

/**
 *  * <p>
 * $!{table.comment} 服务类
 * </p>
 *  *
 *  * @author heaboy
 *  * @since 2021-02-01
 *  
 */
@Service
public class PlanItemServiceImpl extends ServiceImpl<PlanItemMapper, PlanItem> implements IPlanItemService {

    @Override
    public IPage<PlanItem> selectAll(Page<PlanItem> page, PlanItem planItem) {
        return this.baseMapper.selectAll(page, planItem);
    }

    @Override
    public IPage<PlanItem> selectTodayPlanItem(Page<PlanItem> page, PlanItem planItem) {
        return this.baseMapper.selectTodayItem(page, planItem);
    }

    @Override
    public IPage<PlanItem> selectByParentId(Page<PlanItem> page , PlanItem planItem){

        QueryWrapper<PlanItem> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(planItem.getUserNo())) {
            queryWrapper = queryWrapper.like("userNo", planItem.getUserNo());
        }
        if (!ObjectUtils.isEmpty(planItem.getItem())) {
            queryWrapper = queryWrapper.like("item", planItem.getItem());
        }
        if (!ObjectUtils.isEmpty(planItem.getStartTime())) {
            queryWrapper = queryWrapper.like("startTime", planItem.getStartTime());
        }
        if (!ObjectUtils.isEmpty(planItem.getEndTime())) {
            queryWrapper = queryWrapper.like("endTime", planItem.getEndTime());
        }
        if (!ObjectUtils.isEmpty(planItem.getPriority())) {
            queryWrapper = queryWrapper.like("priority", planItem.getPriority());
        }
        if (!ObjectUtils.isEmpty(planItem.getStatus())) {
            queryWrapper = queryWrapper.eq("status", planItem.getStatus());
        }
        if (!ObjectUtils.isEmpty(planItem.getItemTitle())) {
            queryWrapper = queryWrapper.like("itemTitle", planItem.getItemTitle());
        }
        if (!ObjectUtils.isEmpty(planItem.getItemType())) {
            queryWrapper = queryWrapper.like("itemType", planItem.getItemType());
        }
        if (!ObjectUtils.isEmpty(planItem.getParentId())) {
            queryWrapper = queryWrapper.like("parentId", planItem.getParentId());
        }
        if (!ObjectUtils.isEmpty(planItem.getDeleteFlag())) {
            queryWrapper = queryWrapper.eq("deleteFlag", planItem.getDeleteFlag());
        }
        if (!ObjectUtils.isEmpty(planItem.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId", planItem.getCreatorId());
        }
        IPage<PlanItem> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

}
