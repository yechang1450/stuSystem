package com.heaboy.headClassConsumer.student.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.student.entity.Student;
import com.heaboy.service.student.service.IStudentService;
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
@RequestMapping("rest/{version}/student")
public class RestStudentController extends BaseController  {

    @Reference
    private IStudentService studentService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param student
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Student student) {
        Page<Student> page = new Page<Student>(pageNo, pageSize);

        IPage<Student> pageInfo = studentService.index(page, student);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  student);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param student
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Student student){
        return toAjax(studentService.save(student));
    }

    /**
    * 添加
    * @param student
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Student student){
        return toAjax(studentService.updateById(student));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(studentService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(studentService.removeByIds(ids));
    }

}

