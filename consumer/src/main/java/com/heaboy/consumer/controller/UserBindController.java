package com.heaboy.consumer.controller;

import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.consumer.domain.ResponseUserToken;
import com.heaboy.consumer.service.IAuthService;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.relation.entity.UserBind;
import com.heaboy.service.relation.service.IUserBindService;
import com.heaboy.service.student.entity.Student;
import com.heaboy.service.sys.entity.SysUser;
import com.heaboy.service.sys.service.ISysResourceService;
import com.heaboy.service.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author Wangzhen
 * createAt: 2020/5/29
 */
@RestController
@Api(value = "用户绑定接口", tags = {"用户绑定接口"})
@ApiVersion(1)
@RequestMapping("/{version}/bind")
public class UserBindController {



    @Reference
    private IUserBindService userBindService;

    @PostMapping(value = "/bindStudent")
    @ApiOperation(value = "绑定学生", notes = "将学生信息绑定当前登录账户")
    public ResultJson<UserBind> bindStudent(
            @Valid @RequestBody Student student){
        long currentUserId = UserInfoUtil.getCurrentUserId();
        UserBind userBind = userBindService.bindStudent(currentUserId,student);
        if(userBind==null){
            return ResultJson.failure(ResultCode.SERVER_ERROR);
        }
        return ResultJson.ok(userBind);
    }


}
