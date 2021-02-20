package com.heaboy.questionnaireConsumer.questionnaire.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.questionnaire.entity.QuestionnaireOption;
import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;
import com.heaboy.service.questionnaire.service.IQuestionnaireOptionService;
import com.heaboy.service.questionnaire.service.IQuestionnaireQuestionService;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.service.generator.common.PageInfo;
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
@RequestMapping("rest/{version}/questionnaireQuestion")
public class RestQuestionnaireQuestionController extends BaseController  {

    @Reference
    private IQuestionnaireQuestionService questionnaireQuestionService;

    @Reference
    private IQuestionnaireOptionService questionnaireOptionService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param questionnaireQuestion
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, QuestionnaireQuestion questionnaireQuestion) {
        Page<QuestionnaireQuestion> page = new Page<QuestionnaireQuestion>(pageNo, pageSize);

        IPage<QuestionnaireQuestion> pageInfo = questionnaireQuestionService.index(page, questionnaireQuestion);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  questionnaireQuestion);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param questionnaireQuestion
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(QuestionnaireQuestion questionnaireQuestion){
        return toAjax(questionnaireQuestionService.save(questionnaireQuestion));
    }

    /**
    * 添加
    * @param questionnaireQuestion
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(QuestionnaireQuestion questionnaireQuestion){
        return toAjax(questionnaireQuestionService.updateById(questionnaireQuestion));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(questionnaireQuestionService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(questionnaireQuestionService.removeByIds(ids));
    }

    @RequestMapping(value = "deleteQuestion")
    @ApiOperation(value = "删除问题", notes = "删除一条问题的信息，包括问题对应的选项等")
    public AjaxResult deleteQuestion(@RequestBody QuestionnaireQuestion questionnaireQuestion){
        System.out.println(questionnaireQuestion.getQuestionId());
        System.out.println(questionnaireQuestion.getQuestionaireId());
        boolean b = questionnaireQuestionService.deleteQuestion(questionnaireQuestion.getQuestionId(), questionnaireQuestion.getQuestionaireId());
        if (!b){
            AjaxResult.error("题目删除失败！！");
        }
        return AjaxResult.success("题目删除成功!!");
    }

    @RequestMapping(value = "updateQuestion")
    @ApiOperation(value = "修改问卷的题目", notes = "修改问卷中的题目，包括选项内容等")
    public AjaxResult updateQuestion(@RequestBody QuestionnaireQuestion questionnaireQuestion){
        System.out.println(questionnaireQuestion.toString());
        boolean b = questionnaireQuestionService.updateQuestion(questionnaireQuestion);
        if (b){
            return AjaxResult.success("问卷题目修改成功！！");
        }
        return AjaxResult.error("问卷题目修改失败");
    }
}

