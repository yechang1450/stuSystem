package com.heaboy.testConsumer.test.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.consumer.annotation.ApiVersion;
import com.heaboy.service.test.entity.Test;
import com.heaboy.service.test.service.ITestService;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.service.generator.common.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("rest/{version}/test")
public class RestTestController extends BaseController  {

    @Reference
    private ITestService testService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param test
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Test test) {
        Page<Test> page = new Page<Test>(pageNo, pageSize);

        IPage<Test> pageInfo = testService.index(page, test);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  test);
        map.put("pageInfo", new PageInfo(pageInfo));
        return this.success(map);
    }


    /**
    * 添加
    * @param test
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(@RequestBody Test test){
        System.out.println(test);
        return toAjax(true);
    }

    /**
    * 添加
    * @param test
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Test test){
        return toAjax(testService.updateById(test));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(testService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(testService.removeByIds(ids));
    }

}

