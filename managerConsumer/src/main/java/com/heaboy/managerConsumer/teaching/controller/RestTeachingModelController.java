package com.heaboy.managerConsumer.teaching.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.TeachingModel;
import com.heaboy.service.teaching.service.ITeachingModelService;
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
@RequestMapping("rest/{version}/teachingModel")
public class RestTeachingModelController extends BaseController  {

    @Reference
    private ITeachingModelService teachingModelService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param teachingModel
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String createTimeSpace, String reviseTimeSpace, TeachingModel teachingModel) {
        Page<TeachingModel> page = new Page<TeachingModel>(pageNo, pageSize);

        IPage<TeachingModel> pageInfo = teachingModelService.index(page, teachingModel);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  teachingModel);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param teachingModel
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(TeachingModel teachingModel){
        return toAjax(teachingModelService.save(teachingModel));
    }

    /**
    * 添加
    * @param teachingModel
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(TeachingModel teachingModel){
        return toAjax(teachingModelService.updateById(teachingModel));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(teachingModelService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(teachingModelService.removeByIds(ids));
    }

}

