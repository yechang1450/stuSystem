package com.heaboy.questionnaireConsumer.questionnaire.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.consumer.utils.UserInfoUtil;
import com.heaboy.service.questionnaire.entity.Questionnaire;
import com.heaboy.service.questionnaire.entity.QuestionnaireOption;
import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;
import com.heaboy.service.questionnaire.service.IQuestionnaireOptionService;
import com.heaboy.service.questionnaire.service.IQuestionnaireQuestionService;
import com.heaboy.service.questionnaire.service.IQuestionnaireService;
import com.heaboy.consumer.common.controller.BaseController;
import com.heaboy.common.common.web.AjaxResult;
import com.heaboy.service.generator.common.PageInfo;
import io.swagger.models.auth.In;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;
import com.heaboy.consumer.annotation.ApiVersion;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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
@RequestMapping("rest/{version}/questionnaire")
public class RestQuestionnaireController extends BaseController  {

    @Reference
    private IQuestionnaireService questionnaireService;

    @Reference
    private IQuestionnaireQuestionService questionnaireQuestionService;

    @Reference
    private IQuestionnaireOptionService questionnaireOptionService;

    /**
    * 查询列表
    *
    * @param pageNo
    * @param pageSize
    * @param questionnaire
    * @return
    */
    @RequestMapping
    public AjaxResult index(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String startTimeSpace, String endTimeSpace, String createTimeSpace, Questionnaire questionnaire) {
        Page<Questionnaire> page = new Page<Questionnaire>(pageNo, pageSize);

        IPage<Questionnaire> pageInfo = questionnaireService.index(page, questionnaire);

        Map<String, Object> map = new HashMap<>();
        map.put("searchInfo",  questionnaire);
        map.put("pageInfo", new PageInfo(pageInfo));

        return this.success(map);
    }

    /**
    * 添加
    * @param questionnaire
    * @return
    */
    @PostMapping("add")
    public AjaxResult add(Questionnaire questionnaire){
        return toAjax(questionnaireService.save(questionnaire));
    }

    /**
    * 添加
    * @param questionnaire
    * @return
    */
    @PostMapping("edit")
    public AjaxResult edit(Questionnaire questionnaire){
        return toAjax(questionnaireService.updateById(questionnaire));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(questionnaireService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(questionnaireService.removeByIds(ids));
    }


    /**
     * 创建问卷
     * @param questionnaire
     * @return
     */
    @PostMapping("insert")
    @ResponseBody
    public AjaxResult insert(@RequestBody Questionnaire questionnaire){
        System.out.println(questionnaire.getQuestionarieTitle());
        questionnaire.setCreatorId(UserInfoUtil.getCurrentUserId());
        questionnaire.setCreateTime(LocalDateTime.now());
        questionnaire.setStartTime(LocalDateTime.now());
        int dayOfYear = questionnaire.getStartTime().getYear();
        int dayOfMonth = questionnaire.getStartTime().getMonthValue();
        int dayOfMonth1 =questionnaire.getStartTime().getDayOfMonth();
        int hour = questionnaire.getStartTime().getHour();
        int minute = questionnaire.getStartTime().getMinute();
        int second = questionnaire.getStartTime().getSecond();
        String id= String.valueOf(dayOfYear)+ String.valueOf(dayOfMonth)+ String.valueOf(dayOfMonth1)+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second);
        long i1 = Long.valueOf(id);
        questionnaire.setQuestionarieId(i1);
        AjaxResult ajaxResult = new AjaxResult();

        int i = questionnaireService.AddQuestionnaire(questionnaire);
        if (i>0){
            ajaxResult.put("questionnaireId",id);
            ajaxResult.put("code","200");
            ajaxResult.put("msg","创建问卷成功！");
            return ajaxResult;
        }
        else return AjaxResult.error("创建问卷失败！");
    }

    /**
     * 根据id修改问卷
     * @param questionnaire
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public String update(@ModelAttribute Questionnaire questionnaire){
        int i = questionnaireService.updateByid(questionnaire);
        String msg;
        if (i>0){
            msg="修改成功！";
        }
        else msg="修改失败！";
        return msg;
    }

    @RequestMapping(value = "showQuestionnaire")
    @ApiOperation(value = "问卷页面渲染", notes = "对于问卷的页面进行渲染，显示问卷标题和题目等")
    public AjaxResult showQuestionnaire(@RequestParam(value = "questionnaireId",required = false) String questionnaireId){
        //questionnaireId = "1";
        Questionnaire questionnaire = questionnaireService.selectQuestionnaireById(Long.valueOf(questionnaireId));
        List<QuestionnaireQuestion> questionnaireQuestionList = questionnaireQuestionService.selectQuestions(Long.valueOf(questionnaireId));
        for (QuestionnaireQuestion questionnaireQuestion : questionnaireQuestionList){
            if (questionnaireQuestion.getQuestionType().equals("单选题") || questionnaireQuestion.getQuestionType().equals("多选题")){
                Long questionId = questionnaireQuestion.getQuestionId();
                List<QuestionnaireOption> questionnaireOptions = questionnaireOptionService.selectOptions(Long.valueOf(questionnaireId), questionId);
                questionnaireQuestion.setQuestionnaireOptionList(questionnaireOptions);
            }
        }
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("questionnaire",questionnaire);
        ajaxResult.put("questionnaireQuestion",questionnaireQuestionList);
        AjaxResult ajaxResult1 = new AjaxResult();
        if (questionnaire == null){
            ajaxResult1.put("code",500);
            ajaxResult1.put("msg","页面渲染失败！");
        }else {
            ajaxResult1.put("code",200);
            ajaxResult1.put("msg","页面渲染，数据回显成功");
            ajaxResult1.put("data",ajaxResult);
        }
        return ajaxResult1;
    }

}

