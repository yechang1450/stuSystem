package com.heaboy.teacherConsumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.classname.service.IClassNameService;
import com.heaboy.service.course.service.IClassCourseRuleService;
import com.heaboy.service.student.service.IStudentService;
import com.heaboy.service.teacher.entity.ClassCourseActual;
import com.heaboy.service.teacher.entity.ClassCourseActualVo;
import com.heaboy.service.teacher.service.IClassCourseActualService;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@ApiVersion
@RestController
@RequestMapping("rest/{version}/common")
public class TeacherCommonController extends BaseController {

    @Reference
    private IClassNameService classNameService;
    @Reference
    private IStudentService studentService;
    @Reference
    private IClassCourseRuleService classCourseRuleService;

    @GetMapping(value = "/listClasses")
    @ApiOperation(value = "列出班级", notes = "列出所有班级")
    public AjaxResult listClasses(){
        String userName = UserInfoUtil.getCurrentUsername();
        return this.success(classNameService.listByTeacherNo(userName));
    }
    @GetMapping(value = "/listStudents")
    @ApiOperation(value = "列出学生", notes = "列出该班级的学生")
    public AjaxResult listStudents(@RequestParam String classNo){
        return this.success(studentService.listByClassNo(classNo));
    }
    @RequestMapping(value = "/listCourse")
    @ApiOperation(value = "列出科目", notes = "根据老师列出老师教的科目")
    public AjaxResult listCourse(){
        String userName = UserInfoUtil.getCurrentUsername();
        return this.success(classCourseRuleService.listCourseByUserName(userName));
    }
    @RequestMapping(value = "/listCourseByClassNo")
    @ApiOperation(value = "列出科目", notes = "根据班级与老师列出老师教的科目")
    public AjaxResult listCourseByClassNo(@RequestParam String classNo){
        String userName = UserInfoUtil.getCurrentUsername();
        return this.success(classCourseRuleService.listCourseByClassNoAndUserName(classNo,userName));
    }
}
