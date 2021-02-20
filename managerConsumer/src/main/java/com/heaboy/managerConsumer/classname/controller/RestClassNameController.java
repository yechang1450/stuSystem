package com.heaboy.managerConsumer.classname.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.classname.entity.ClassName;
import com.heaboy.service.classname.service.IClassNameService;
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
@RequestMapping("rest/{version}/className")
public class RestClassNameController extends BaseController  {

    @Reference
    private IClassNameService classNameService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param className
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String createTimeSpace, ClassName className) {
        Page<ClassName> page = new Page<ClassName>(pageNo, pageSize);

        IPage<ClassName> pageInfo = classNameService.index(page, className);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  className);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param className
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(ClassName className){
        return toAjax(classNameService.save(className));
    }

    /**
    * 添加
    * @param className
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(ClassName className){
        return toAjax(classNameService.updateById(className));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(classNameService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(classNameService.removeByIds(ids));
    }

}

