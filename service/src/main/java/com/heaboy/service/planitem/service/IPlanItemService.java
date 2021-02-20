package com.heaboy.service.planitem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.planitem.entity.PlanItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  * <p>
 * $!{table.comment} 服务类
 * </p>
 *  *
 *  * @author heaboy
 *  * @since 2021-02-01
 *  
 */
public interface IPlanItemService extends IService<PlanItem> {

    /**
     * @param page
     * @param planItem
     * @return
     */
    IPage<PlanItem> selectAll(Page<PlanItem> page, PlanItem planItem);

    IPage<PlanItem> selectTodayPlanItem(Page<PlanItem> page, PlanItem planItem);

    IPage<PlanItem> selectByParentId(Page<PlanItem> page, PlanItem planItem);
}
