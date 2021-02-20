package com.heaboy.managerConsumer.teaching.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.Teaching;
import com.heaboy.service.teaching.service.ITeachingService;
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
@RequestMapping("rest/{version}/teaching")
public class RestTeachingController extends BaseController  {

    @Reference
    private ITeachingService teachingService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param teaching
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String teachingStartTimeSpace, String teachingEndTimeSpace, String createTimeSpace, Teaching teaching) {
        Page<Teaching> page = new Page<Teaching>(pageNo, pageSize);

        IPage<Teaching> pageInfo = teachingService.index(page, teaching);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  teaching);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param teaching
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Teaching teaching){
        return toAjax(teachingService.save(teaching));
    }

    /**
    * 添加
    * @param teaching
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Teaching teaching){
        return toAjax(teachingService.updateById(teaching));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(teachingService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(teachingService.removeByIds(ids));
    }

}

