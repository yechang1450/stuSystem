package com.heaboy.studentConsumer.studentteaching.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.studentteaching.entity.StudentTeaching;
import com.heaboy.service.studentteaching.service.IStudentTeachingService;
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
@RequestMapping("rest/{version}/studentTeaching")
public class RestStudentTeachingController extends BaseController  {

    @Reference
    private IStudentTeachingService studentTeachingService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param studentTeaching
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String teachingTimeSpace, StudentTeaching studentTeaching) {
        Page<StudentTeaching> page = new Page<StudentTeaching>(pageNo, pageSize);

        IPage<StudentTeaching> pageInfo = studentTeachingService.index(page, studentTeaching);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  studentTeaching);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param studentTeaching
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(StudentTeaching studentTeaching){
        return toAjax(studentTeachingService.save(studentTeaching));
    }

    /**
    * 添加
    * @param studentTeaching
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(StudentTeaching studentTeaching){
        return toAjax(studentTeachingService.updateById(studentTeaching));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(studentTeachingService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(studentTeachingService.removeByIds(ids));
    }

}

