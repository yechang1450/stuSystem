package com.heaboy.managerConsumer.course.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.course.entity.ClassCourseRule;
import com.heaboy.service.course.service.IClassCourseRuleService;
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
@RequestMapping("rest/{version}/classCourseRule")
public class RestClassCourseRuleController extends BaseController  {

    @Reference
    private IClassCourseRuleService classCourseRuleService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param classCourseRule
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String startTimeSpace, String endTimeSpace, String createTimeSpace, ClassCourseRule classCourseRule) {
        Page<ClassCourseRule> page = new Page<ClassCourseRule>(pageNo, pageSize);

        IPage<ClassCourseRule> pageInfo = classCourseRuleService.index(page, classCourseRule);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  classCourseRule);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param classCourseRule
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(ClassCourseRule classCourseRule){
        return toAjax(classCourseRuleService.save(classCourseRule));
    }

    /**
    * 添加
    * @param classCourseRule
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(ClassCourseRule classCourseRule){
        return toAjax(classCourseRuleService.updateById(classCourseRule));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(classCourseRuleService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(classCourseRuleService.removeByIds(ids));
    }

}

