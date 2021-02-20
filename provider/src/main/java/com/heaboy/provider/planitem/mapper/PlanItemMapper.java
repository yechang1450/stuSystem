package com.heaboy.provider.planitem.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.planitem.entity.PlanItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface PlanItemMapper extends BaseMapper<PlanItem> {
    IPage<PlanItem> selectAll(Page<PlanItem> page, @Param("planItem") PlanItem planItem);

    IPage<PlanItem> selectTodayItem(Page<PlanItem> page, @Param("planItem") PlanItem planItem);
}