package com.heaboy.teacherConsumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.consumer.domain.UserDetail;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.classname.service.IClassNameService;
import com.heaboy.service.course.service.IClassCourseRuleService;
import com.heaboy.service.student.service.IStudentService;
import com.heaboy.service.studentgrade.entity.StudentGrade;
import com.heaboy.service.studentgrade.service.IStudentGradeService;
import com.heaboy.service.studentgrade.entity.StudentGradeVo;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiVersion
@RestController
@RequestMapping("rest/{version}/scoreInfo")
public class TeacherScoreController extends BaseController {

    @Reference
    private IStudentGradeService studentGradeService;
    @Reference
    private IStudentService studentService;
    @Reference
    private IClassCourseRuleService classCourseRuleService;

    @RequestMapping("/index/{currentPage}/{pageSize}")
    @ApiOperation(value = "成绩信息初始化", notes = "按分页查出成绩信息")
    public AjaxResult scoreInfo(
            @RequestParam(value = "currentPage",defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            StudentGrade studentGrade
            ){
         String userName = UserInfoUtil.getCurrentUsername();
        Page<StudentGradeVo> page = new Page<>(pageNo,pageSize);
        IPage<StudentGradeVo> index = studentGradeService.indexPage(page, studentGrade,userName);
        return this.success(index);
    }


    @PostMapping(value = "/add")
    @ApiOperation(value = "成绩信息添加", notes = "添加一条成绩信息")
    public AjaxResult add(@RequestBody StudentGrade studentGrade){
        System.out.println(studentGrade);
        return this.toAjax(studentGradeService.saveScore(studentGrade));
    }

    @PostMapping(value = "/deleteAll")
    @ApiOperation(value = "成绩信息删除", notes = "删除一条成绩信息")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return this.toAjax(studentGradeService.removeByIds(ids));
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改成绩信息", notes = "修改一条成绩信息")
    public AjaxResult update(@RequestBody StudentGrade studentGrade){
        return this.toAjax(studentGradeService.updateScore(studentGrade));
    }



}
