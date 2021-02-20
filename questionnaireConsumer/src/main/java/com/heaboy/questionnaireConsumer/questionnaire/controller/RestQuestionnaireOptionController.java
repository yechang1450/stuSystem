package com.heaboy.questionnaireConsumer.questionnaire.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.questionnaire.entity.QuestionnaireOption;
import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;
import com.heaboy.service.questionnaire.service.IQuestionnaireOptionService;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.service.generator.common.PageInfo;
import com.heaboy.service.questionnaire.service.IQuestionnaireQuestionService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("rest/{version}/questionnaireOption")
public class RestQuestionnaireOptionController extends BaseController  {

    @Reference
    private IQuestionnaireOptionService questionnaireOptionService;
    @Reference
    private IQuestionnaireQuestionService questionnaireQuestionService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param questionnaireOption
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, QuestionnaireOption questionnaireOption) {
        Page<QuestionnaireOption> page = new Page<QuestionnaireOption>(pageNo, pageSize);

        IPage<QuestionnaireOption> pageInfo = questionnaireOptionService.index(page, questionnaireOption);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  questionnaireOption);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param questionnaireOption
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(QuestionnaireOption questionnaireOption){
        return toAjax(questionnaireOptionService.save(questionnaireOption));
    }

    /**
    * 添加
    * @param questionnaireOption
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(QuestionnaireOption questionnaireOption){
        return toAjax(questionnaireOptionService.updateById(questionnaireOption));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(questionnaireOptionService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(questionnaireOptionService.removeByIds(ids));
    }
    @PostMapping("increase")
    @ResponseBody
    public AjaxResult increase(@RequestBody QuestionnaireQuestion questionnaireQuestion) {
        LocalDateTime now = LocalDateTime.now();
        int dayOfYear = now.getYear();
        int dayOfMonth = now.getMonthValue();
        int dayOfMonth1 = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        String id= String.valueOf(dayOfYear)+ String.valueOf(dayOfMonth)+ String.valueOf(dayOfMonth1)+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second);
        long i1 = Long.valueOf(id);

        questionnaireQuestion.setQuestionId(i1);
        Long insert = questionnaireQuestionService.insert(questionnaireQuestion);

        if (questionnaireQuestion.getQuestionType().equals("单选题") || questionnaireQuestion.getQuestionType().equals("多选题")){
            List<QuestionnaireOption> list = questionnaireQuestion.getQuestionnaireOptionList();
            for (QuestionnaireOption option : list){
                option.setQuestionId(questionnaireQuestion.getQuestionId());
                option.setQuestionnaireId(questionnaireQuestion.getQuestionaireId());
            }

            int insert1 = questionnaireOptionService.insert(list);
            if (insert>0&&insert1>0){
                return AjaxResult.success("插入成功");
            }else return AjaxResult.error("插入失败");
        }else {
            if (insert>0){
                return AjaxResult.success("插入成功");
            }else return AjaxResult.error("插入失败");
        }
    }

    @RequestMapping(value = "deleteQuestionOption")
    @ApiOperation(value = "删除问卷题目某一选项", notes = "在修改问题的时候，可能会面临删除某一个选项的问题，调用此接口")
    public AjaxResult deleteQuestionOption(@RequestBody QuestionnaireOption questionnaireOption){

        boolean b = questionnaireOptionService.deleteQuestionOption(questionnaireOption);
        if (!b){
            return AjaxResult.error("题目选项删除失败！！");
        }
        return AjaxResult.success("题目选项删除成功！！");
    }

    @RequestMapping(value = "InsertQuestionOption")
    @ApiOperation(value = "插入问卷题目某一选项", notes = "在修改问题的时候，可能会面临插入某一个选项的问题，调用此接口")
    public AjaxResult InsertQuestionOption(@RequestBody QuestionnaireOption questionnaireOption){

        boolean b = questionnaireOptionService.InsertQuestionOption(questionnaireOption);
        if (!b){
            return AjaxResult.error("题目选项插入失败！！");
        }
        return AjaxResult.success("题目选项插入成功！！");
    }

}

