package com.heaboy.managerConsumer.course.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.course.entity.ClassCourse;
import com.heaboy.service.course.service.IClassCourseService;
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
@RequestMapping("rest/{version}/classCourse")
public class RestClassCourseController extends BaseController  {

    @Reference
    private IClassCourseService classCourseService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param classCourse
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, ClassCourse classCourse) {
        Page<ClassCourse> page = new Page<ClassCourse>(pageNo, pageSize);

        IPage<ClassCourse> pageInfo = classCourseService.index(page, classCourse);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  classCourse);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param classCourse
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(ClassCourse classCourse){
        return toAjax(classCourseService.save(classCourse));
    }

    /**
    * 添加
    * @param classCourse
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(ClassCourse classCourse){
        return toAjax(classCourseService.updateById(classCourse));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(classCourseService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(classCourseService.removeByIds(ids));
    }

}

