package com.heaboy.managerConsumer.stage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.stage.entity.Stage;
import com.heaboy.service.stage.service.IStageService;
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
@RequestMapping("rest/{version}/stage")
public class RestStageController extends BaseController  {

    @Reference
    private IStageService stageService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param stage
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Stage stage) {
        Page<Stage> page = new Page<Stage>(pageNo, pageSize);

        IPage<Stage> pageInfo = stageService.index(page, stage);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  stage);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param stage
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Stage stage){
        return toAjax(stageService.save(stage));
    }

    /**
    * 添加
    * @param stage
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Stage stage){
        return toAjax(stageService.updateById(stage));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(stageService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(stageService.removeByIds(ids));
    }

}

