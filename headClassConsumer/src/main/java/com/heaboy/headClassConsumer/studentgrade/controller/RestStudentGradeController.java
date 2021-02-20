package com.heaboy.headClassConsumer.studentgrade.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.studentgrade.entity.StudentGrade;
import com.heaboy.service.studentgrade.service.IStudentGradeService;
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
@RequestMapping("rest/{version}/studentGrade")
public class RestStudentGradeController extends BaseController  {

    @Reference
    private IStudentGradeService studentGradeService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param studentGrade
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, StudentGrade studentGrade) {
        Page<StudentGrade> page = new Page<StudentGrade>(pageNo, pageSize);

        IPage<StudentGrade> pageInfo = studentGradeService.index(page, studentGrade);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  studentGrade);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param studentGrade
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(StudentGrade studentGrade){
        return toAjax(studentGradeService.save(studentGrade));
    }

    /**
    * 添加
    * @param studentGrade
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(StudentGrade studentGrade){
        return toAjax(studentGradeService.updateById(studentGrade));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(studentGradeService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(studentGradeService.removeByIds(ids));
    }

}

