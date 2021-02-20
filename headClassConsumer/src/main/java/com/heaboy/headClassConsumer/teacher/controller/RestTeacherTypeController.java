package com.heaboy.headClassConsumer.teacher.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teacher.entity.TeacherType;
import com.heaboy.service.teacher.service.ITeacherTypeService;
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
@RequestMapping("rest/{version}/teacherType")
public class RestTeacherTypeController extends BaseController  {

    @Reference
    private ITeacherTypeService teacherTypeService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param teacherType
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, TeacherType teacherType) {
        Page<TeacherType> page = new Page<TeacherType>(pageNo, pageSize);

        IPage<TeacherType> pageInfo = teacherTypeService.index(page, teacherType);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  teacherType);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param teacherType
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(TeacherType teacherType){
        return toAjax(teacherTypeService.save(teacherType));
    }

    /**
    * 添加
    * @param teacherType
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(TeacherType teacherType){
        return toAjax(teacherTypeService.updateById(teacherType));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(teacherTypeService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(teacherTypeService.removeByIds(ids));
    }

}

