package com.heaboy.teacherConsumer.teacher.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teacher.entity.ClassCourseActual;
import com.heaboy.service.teacher.service.IClassCourseActualService;
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
@RequestMapping("rest/{version}/classCourseActual")
public class RestClassCourseActualController extends BaseController  {

    @Reference
    private IClassCourseActualService classCourseActualService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param classCourseActual
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String startTimeSpace, String endTImeSpace, String createTimeSpace, ClassCourseActual classCourseActual) {
        Page<ClassCourseActual> page = new Page<ClassCourseActual>(pageNo, pageSize);

        IPage<ClassCourseActual> pageInfo = classCourseActualService.index(page, classCourseActual);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  classCourseActual);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param classCourseActual
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(ClassCourseActual classCourseActual){
        return toAjax(classCourseActualService.save(classCourseActual));
    }

    /**
    * 添加
    * @param classCourseActual
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(ClassCourseActual classCourseActual){
        return toAjax(classCourseActualService.updateById(classCourseActual));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(classCourseActualService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(classCourseActualService.removeByIds(ids));
    }

}

