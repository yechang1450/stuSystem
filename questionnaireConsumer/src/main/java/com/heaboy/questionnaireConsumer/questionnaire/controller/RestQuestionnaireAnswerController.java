package com.heaboy.questionnaireConsumer.questionnaire.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.questionnaire.entity.QuestionnaireAnswer;
import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;
import com.heaboy.service.questionnaire.service.IQuestionnaireAnswerService;
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

import java.util.ArrayList;
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
@RequestMapping("rest/{version}/questionnaireAnswer")
public class RestQuestionnaireAnswerController extends BaseController  {

    @Reference
    private IQuestionnaireAnswerService questionnaireAnswerService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param questionnaireAnswer
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, QuestionnaireAnswer questionnaireAnswer) {
        Page<QuestionnaireAnswer> page = new Page<QuestionnaireAnswer>(pageNo, pageSize);

        IPage<QuestionnaireAnswer> pageInfo = questionnaireAnswerService.index(page, questionnaireAnswer);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  questionnaireAnswer);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }


    /**
    * 添加
    * @param questionnaireAnswer
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(QuestionnaireAnswer questionnaireAnswer){
        return toAjax(questionnaireAnswerService.save(questionnaireAnswer));
    }

    /**
    * 添加
    * @param questionnaireAnswer
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(QuestionnaireAnswer questionnaireAnswer){
        return toAjax(questionnaireAnswerService.updateById(questionnaireAnswer));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(questionnaireAnswerService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(questionnaireAnswerService.removeByIds(ids));
    }

    @RequestMapping(value = "answerQuestionnaire")
    @ApiOperation(value = "问卷答题接口", notes = "对于用户回答的试卷每道题同时存入数据库")
    @ResponseBody
    public AjaxResult answerQuestionnaire(@RequestBody List<QuestionnaireQuestion> questionnaireQuestions){
        List<QuestionnaireAnswer> questionnaireAnswerList = new ArrayList<>();
        for (QuestionnaireQuestion question: questionnaireQuestions){
            QuestionnaireAnswer questionnaireAnswer = new QuestionnaireAnswer();
            questionnaireAnswer.setAnswer(question.getAnswer());
            questionnaireAnswer.setQuestionnaireId(question.getQuestionaireId());
            questionnaireAnswer.setQuestionId(question.getQuestionId());
            questionnaireAnswer.setUserId(UserInfoUtil.getCurrentUserId());
            questionnaireAnswerList.add(questionnaireAnswer);
        }
        boolean b = questionnaireAnswerService.answerQuestionnaire(questionnaireAnswerList);
        if (b){
            return AjaxResult.success("问卷回答成功！！");
        }
        return AjaxResult.error("问卷回答失败！！");
    }

}

