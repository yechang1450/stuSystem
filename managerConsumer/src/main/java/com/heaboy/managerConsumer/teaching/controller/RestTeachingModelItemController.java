package com.heaboy.managerConsumer.teaching.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.TeachingModelItem;
import com.heaboy.service.teaching.service.ITeachingModelItemService;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.service.generator.common.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heaboy.consumer.annotation.ApiVersion;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
* <p>
* 前端控制器
* </p>
* @author heaboy
* @since 2019-03-11
*/
@ApiVersion
@RestController
@RequestMapping("rest/{version}/teachingModelItem")
public class RestTeachingModelItemController extends BaseController  {

    @Reference
    private ITeachingModelItemService teachingModelItemService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param teachingModelItem
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String createTimeSpace, String reviseTimeSpace, TeachingModelItem teachingModelItem) {
        Page<TeachingModelItem> page = new Page<TeachingModelItem>(pageNo, pageSize);

        IPage<TeachingModelItem> pageInfo = teachingModelItemService.index(page, teachingModelItem);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  teachingModelItem);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param teachingModelItem
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(TeachingModelItem teachingModelItem){
        return toAjax(teachingModelItemService.save(teachingModelItem));
    }

    /**
    * 添加
    * @param teachingModelItem
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(TeachingModelItem teachingModelItem){
        return toAjax(teachingModelItemService.updateById(teachingModelItem));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(teachingModelItemService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(teachingModelItemService.removeByIds(ids));
    }

}

