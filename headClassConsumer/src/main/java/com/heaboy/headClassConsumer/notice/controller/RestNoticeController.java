package com.heaboy.headClassConsumer.notice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.notice.entity.Notice;
import com.heaboy.service.notice.service.INoticeService;
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
@RequestMapping("rest/{version}/notice")
public class RestNoticeController extends BaseController  {

    @Reference
    private INoticeService noticeService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param notice
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String createTimeSpace, Notice notice) {
        Page<Notice> page = new Page<Notice>(pageNo, pageSize);

        IPage<Notice> pageInfo = noticeService.index(page, notice);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  notice);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param notice
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Notice notice){
        return toAjax(noticeService.save(notice));
    }

    /**
    * 添加
    * @param notice
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Notice notice){
        return toAjax(noticeService.updateById(notice));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(noticeService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(noticeService.removeByIds(ids));
    }

}

