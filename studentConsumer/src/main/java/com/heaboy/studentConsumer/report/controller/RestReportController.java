package com.heaboy.studentConsumer.report.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.common.common.entity.ResultJson;
import com.heaboy.service.report.entity.Report;
import com.heaboy.service.report.service.IReportService;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.service.generator.common.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("rest/{version}/report")
public class RestReportController extends BaseController  {

    @Reference
    private IReportService reportService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param report
    * @return
    */
    @PreAuthorize("hasAuthority('/user')")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @PostMapping("/list/{currentPage}/{pageSize}")
    public ResultJson index(@RequestBody Report report, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {

        IPage<Report> pageList = reportService.index(new Page<>(currentPage, pageSize), report);

        return ResultJson.ok(pageList);
    }

    //自带的查询代码
//    @RequestMapping
//    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String reportTimeSpace, String studentReportTimeSpace, Report report) {
//        Page<Report> page = new Page<Report>(pageNo, pageSize);
//
//        IPage<Report> pageInfo = reportService.index(page, report);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("searchInfo",  report);
//        map.put("pageInfo", new PageInfo(pageInfo));
//
//        return this.success(map);
//    }


    /**
    * 添加
    * @param report
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Report report){
        return toAjax(reportService.save(report));
    }

    /**
    * 添加
    * @param report
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Report report){
        return toAjax(reportService.updateById(report));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(reportService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(reportService.removeByIds(ids));
    }

}

