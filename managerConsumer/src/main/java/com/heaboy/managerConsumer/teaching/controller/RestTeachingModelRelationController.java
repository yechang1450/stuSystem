package com.heaboy.managerConsumer.teaching.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.TeachingModelRelation;
import com.heaboy.service.teaching.service.ITeachingModelRelationService;
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
@RequestMapping("rest/{version}/teachingModelRelation")
public class RestTeachingModelRelationController extends BaseController  {

    @Reference
    private ITeachingModelRelationService teachingModelRelationService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param teachingModelRelation
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, TeachingModelRelation teachingModelRelation) {
        Page<TeachingModelRelation> page = new Page<TeachingModelRelation>(pageNo, pageSize);

        IPage<TeachingModelRelation> pageInfo = teachingModelRelationService.index(page, teachingModelRelation);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  teachingModelRelation);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param teachingModelRelation
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(TeachingModelRelation teachingModelRelation){
        return toAjax(teachingModelRelationService.save(teachingModelRelation));
    }

    /**
    * 添加
    * @param teachingModelRelation
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(TeachingModelRelation teachingModelRelation){
        return toAjax(teachingModelRelationService.updateById(teachingModelRelation));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(teachingModelRelationService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(teachingModelRelationService.removeByIds(ids));
    }

}

