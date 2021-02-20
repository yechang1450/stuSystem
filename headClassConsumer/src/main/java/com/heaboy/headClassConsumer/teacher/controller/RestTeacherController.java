package com.heaboy.headClassConsumer.teacher.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teacher.entity.Teacher;
import com.heaboy.service.teacher.service.ITeacherService;
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
@RequestMapping("rest/{version}/teacher")
public class RestTeacherController extends BaseController  {

    @Reference
    private ITeacherService teacherService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param teacher
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Teacher teacher) {
        Page<Teacher> page = new Page<Teacher>(pageNo, pageSize);

        IPage<Teacher> pageInfo = teacherService.index(page, teacher);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  teacher);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param teacher
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Teacher teacher){
        return toAjax(teacherService.save(teacher));
    }

    /**
    * 添加
    * @param teacher
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Teacher teacher){
        return toAjax(teacherService.updateById(teacher));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(teacherService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(teacherService.removeByIds(ids));
    }

}

