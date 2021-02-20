package com.heaboy.teacherConsumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.consumer.domain.ResponseUserToken;
import com.heaboy.service.studentgrade.entity.StudentGrade;
import com.heaboy.service.studentgrade.service.IStudentGradeService;
import com.heaboy.service.sys.entity.SysUser;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ApiVersion
@RestController
@RequestMapping("rest/{version}/teacher")
public class TeacherTestController extends BaseController {

    @Reference
    private IStudentGradeService studentGradeService;

    @RequestMapping("test")
    public List<StudentGrade> testList(){
        return studentGradeService.list();
    }


}
