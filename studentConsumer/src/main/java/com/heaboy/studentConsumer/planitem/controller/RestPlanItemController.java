package com.heaboy.studentConsumer.planitem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.planitem.entity.PlanItem;
import com.heaboy.service.planitem.service.IPlanItemService;
import com.heaboy.consumer.common.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import com.heaboy.consumer.annotation.ApiVersion;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器PlanItem
 * </p>
 *
 * @author heaboy_YangWenchang
 * @since 2021-2-1
 */
@Slf4j
@ApiVersion
@RestController
@RequestMapping("rest/{version}/planItem")
public class RestPlanItemController extends BaseController {

    @Reference
    private IPlanItemService planItemService;

    /**
     * 查询所有item信息
     * selectAll
     *
     * @param currentPage
     * @param pageSize
     * @param planItem
     * @return
     */
    @PreAuthorize("hasAuthority('/planItem')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("selectAll/{currentPage}/{pageSize}")
    public ResultJson selectAll(@RequestBody PlanItem planItem, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        planItem.setParentId(0L);
        IPage<PlanItem> pageList = planItemService.selectAll(new Page<>(currentPage, pageSize), planItem);
        if (pageList != null) {
            return ResultJson.ok(pageList);
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 查询今天的item
     * selectTodayPlanItem
     *
     * @return
     */
    @PreAuthorize("hasAuthority('/planItem')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("selectTodayPlanItem/{currentPage}/{pageSize}")
    public ResultJson selectTodayPlanItem(@RequestBody PlanItem planItem, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        planItem.setParentId(0L);
        IPage<PlanItem> planItemList = planItemService.selectTodayPlanItem(new Page<>(currentPage, pageSize), planItem);
        if (planItemList != null) {
            return ResultJson.ok(planItemList);
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 查询ByParentId
     * selectByParentId
     *
     * @param planItem
     * @return
     */
    @PreAuthorize("hasAuthority('/planItem')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("selectByParentId/{currentPage}/{pageSize}")
    public ResultJson selectByParentId(@RequestBody PlanItem planItem, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        IPage<PlanItem> planItemList = planItemService.selectByParentId(new Page<>(currentPage, pageSize), planItem);
        if (planItemList != null) {
            return ResultJson.ok(planItemList);
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 查询ById
     * selectById
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('/planItem')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("selectById/{id}")
    public ResultJson selectById(@PathVariable Long id) {
        PlanItem planItem = planItemService.getById(id);
        if (planItem != null) {
            return ResultJson.ok(planItem);
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 添加&更新
     * saveOrUpdate
     *
     * @param planItem
     * @return
     */
    @PreAuthorize("hasAuthority('/planItem')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("saveOrUpdate")
    public ResultJson saveOrUpdate(@RequestBody PlanItem planItem) {
        log.info("添加/更新item " + planItem.getItem());
        planItem.setCreateTime(LocalDateTime.now());
        if (planItem.getItemType() != null) {
            planItem.setCreatorId(UserInfoUtil.getCurrentUserId());
        }
        boolean flag = planItemService.saveOrUpdate(planItem);
        if (flag) {
            return ResultJson.ok();
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 点击完成
     * donePlanItem
     *
     * @param planItem
     * @return
     */
    @PreAuthorize("hasAuthority('/planItem')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("donePlanItem")
    public ResultJson donePlanItem(@RequestBody PlanItem planItem) {
        if (planItem.getId() > 0) {
            planItem.setCreateTime(LocalDateTime.now());
        }
        planItem.setStatus(true);
        boolean flag = planItemService.saveOrUpdate(planItem);
        if (flag) {
            log.info(" 完成item " + planItem.getItem());
            return ResultJson.ok();
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    /**
     * 批量删除(更改)
     * deletePlanItem
     *
     * @param ids
     * @return
     */
    @PreAuthorize("hasAuthority('/planItem')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("deletePlanItem")
    public ResultJson deletePlanItem(@RequestParam("ids") Long[] ids) {
        boolean flag = planItemService.removeByIds(Arrays.asList(ids));
        if (flag) {
            log.info(" 删除 item 成功 ");
            return ResultJson.ok();
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
//        ArrayList<PlanItem> planItems = new ArrayList<>();
//        for (long id : ids) {
//            PlanItem planItem = new PlanItem();
//            planItem.setId(id);
//            planItem.setDeleteFlag(true);
//            planItem.setCreateTime(LocalDateTime.now());
//            planItems.add(planItem);
//        }
//        boolean flag = planItemService.updateBatchById(planItems);
//        if (flag) {
//            log.info(" 删除 item 成功 ");
//            return ResultJson.ok();
//        }
//        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }
}