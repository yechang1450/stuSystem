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
import com.heaboy.service.studentgrade.entity.StudentGrade;
import com.heaboy.service.studentgrade.entity.StudentGradeVo;
import com.heaboy.service.studentgrade.service.IStudentGradeService;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiVersion
@RestController
@RequestMapping("rest/{version}/studentDaily")
public class TeacherStudentDailyController extends BaseController {

    @Reference
    private ICareerService careerService;

    @RequestMapping("/index/{currentPage}/{pageSize}")
    @ApiOperation(value = "学生生涯信息初始化", notes = "按分页查出学生生涯信息")
    public AjaxResult scoreInfo(
            @RequestParam(value = "currentPage",defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
            @RequestBody Career career
    ){
        String userName = UserInfoUtil.getCurrentUsername();
        Page<CareerVo> page = new Page<>(pageNo,pageSize);
        IPage<CareerVo> index = careerService.indexPage(page, career,userName);
        return this.success(index);
    }
    @PostMapping(value = "/add")
    @ApiOperation(value = "学生生涯信息添加", notes = "添加一条学生生涯信息")
    public AjaxResult add(@RequestBody Career career){
        long userId = UserInfoUtil.getCurrentUserId();
        return this.toAjax(careerService.saveCareer(career,userId));
    }
    @PostMapping(value = "/delete")
    @ApiOperation(value = "学生生涯信息删除", notes = "删除一条学生生涯信息")
    public AjaxResult delete(Long id){
        return this.toAjax(careerService.removeByCareerId(id));
    }
    @PostMapping(value = "/deleteAll")
    @ApiOperation(value = "学生生涯信息删除", notes = "删除一条学生生涯信息")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return this.toAjax(careerService.removeByCareerIds(ids));
    }
    @PostMapping(value = "/update")
    @ApiOperation(value = "修改学生生涯信息", notes = "修改一条学生生涯信息")
    public AjaxResult update(@RequestBody Career career){
        return this.toAjax(careerService.updateById(career));
    }


}
