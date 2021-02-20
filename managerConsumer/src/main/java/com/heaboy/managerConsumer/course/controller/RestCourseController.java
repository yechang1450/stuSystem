package com.heaboy.managerConsumer.course.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.course.entity.Course;
import com.heaboy.service.course.service.ICourseService;
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
@RequestMapping("rest/{version}/course")
public class RestCourseController extends BaseController  {

    @Reference
    private ICourseService courseService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param course
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Course course) {
        Page<Course> page = new Page<Course>(pageNo, pageSize);

        IPage<Course> pageInfo = courseService.index(page, course);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  course);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param course
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Course course){
        return toAjax(courseService.save(course));
    }

    /**
    * 添加
    * @param course
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Course course){
        return toAjax(courseService.updateById(course));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(courseService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(courseService.removeByIds(ids));
    }

}

