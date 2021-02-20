package com.heaboy.headClassConsumer.career.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.career.entity.Career;
import com.heaboy.service.career.service.ICareerService;
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
@RequestMapping("rest/{version}/career")
public class RestCareerController extends BaseController  {

    @Reference
    private ICareerService careerService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param career
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String timePointSpace, String createtimeSpace, String createTimeSpace, Career career) {
        Page<Career> page = new Page<Career>(pageNo, pageSize);

        IPage<Career> pageInfo = careerService.index(page, career);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  career);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param career
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Career career){
        return toAjax(careerService.save(career));
    }

    /**
    * 添加
    * @param career
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Career career){
        return toAjax(careerService.updateById(career));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(careerService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(careerService.removeByIds(ids));
    }

}

