package com.heaboy.studentConsumer.comment.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.heaboy.common.common.entity.ResultCode;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.service.comment.entity.Comment;
import com.heaboy.service.comment.service.ICommentService;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.service.generator.common.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.heaboy.consumer.annotation.ApiVersion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.time.LocalDateTime;
/**
 * <p>
 * 前端控制器
 * </p>
 * @author heaboy
 * @since 2019-03-11
 */
@ApiVersion
@RestController
@RequestMapping("rest/{version}/comment")
public class RestCommentController extends BaseController  {

    @Reference
    private ICommentService commentService;

    /**
     * 查询列表
     * @param currentPage
     * @param pageSize
     * @param comment
     * @return
     */
    @PreAuthorize("hasAuthority('/comment')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/list/{currentPage}/{pageSize}")
    public ResultJson index(@RequestBody Comment comment, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        IPage<Comment> pageList = commentService.index(new Page<>(currentPage, pageSize), comment);
        return ResultJson.ok(pageList);
    }
    @PreAuthorize("hasAuthority('/comment')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/saveOrUpdate")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    public ResultJson saveOrUpdate(@RequestBody Comment comment) {


        if(comment.getId()>0){
            comment.setCreateTime(LocalDateTime.now());
        }
        boolean flag = commentService.saveOrUpdate(comment);
        if(flag){
            return ResultJson.ok();
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }

    @PreAuthorize("hasAuthority('/comment/delete')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("/delete")
    public ResultJson delete(@RequestParam("ids") Long[] ids) {
        boolean flag = commentService.removeByIds(Arrays.asList(ids));
        if(flag){
            return ResultJson.ok();
        }

        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }
    /**
     * findPlanItemById
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('/comment')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @GetMapping("findCommentById/{id}")
    public ResultJson findPlanItemById(@PathVariable Long id) {
        Comment comment = commentService.getById(id);
        if(comment != null){
            return ResultJson.ok(comment);
        }
        return ResultJson.failure(ResultCode.BAD_REQUEST);
    }
}

