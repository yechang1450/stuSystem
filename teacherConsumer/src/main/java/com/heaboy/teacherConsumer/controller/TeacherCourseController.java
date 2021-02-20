package com.heaboy.teacherConsumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.career.entity.Career;
import com.heaboy.service.career.entity.CareerVo;
import com.heaboy.service.career.service.ICareerService;
import com.heaboy.service.course.service.IClassCourseRuleService;
import com.heaboy.service.teacher.entity.ClassCourseActual;
import com.heaboy.service.teacher.entity.ClassCourseActualVo;
import com.heaboy.service.teacher.service.IClassCourseActualService;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiVersion
@RestController
@RequestMapping("rest/{version}/courseInfo")
public class TeacherCourseController extends BaseController {

    @Reference
    private IClassCourseActualService classCourseActualService;

    @PostMapping("/index/{currentPage}/{pageSize}")
    @ApiOperation(value = "教师课程查询", notes = "按分页查出教师课程")
    public AjaxResult scoreInfo(
            @RequestParam(value = "currentPage",defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            ClassCourseActual courseActual
    ){
        String userName = UserInfoUtil.getCurrentUsername();
        Page<ClassCourseActualVo> page = new Page<>(pageNo,pageSize);
        IPage<ClassCourseActualVo> index = classCourseActualService.indexPage(page, courseActual, userName);
        return this.success(index);
    }
    @PostMapping(value = "/update")
    @ApiOperation(value = "修改教师课程信息", notes = "修改一条教师课程信息")
    public AjaxResult update(@RequestBody ClassCourseActual courseActual){
        return this.toAjax(classCourseActualService.updateById(courseActual));
    }


}
