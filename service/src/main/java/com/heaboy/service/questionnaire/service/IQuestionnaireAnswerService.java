package com.heaboy.service.questionnaire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.questionnaire.entity.QuestionnaireAnswer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface IQuestionnaireAnswerService extends IService<QuestionnaireAnswer> {

    /**
    *
    * @param page
    * @param questionnaireAnswer
    * @return
    */
    IPage<QuestionnaireAnswer> index(Page<QuestionnaireAnswer> page ,QuestionnaireAnswer questionnaireAnswer);

    /**
     * 将问卷的问题答案入库
     * @param questionnaireAnswerList
     * @return
     */
    boolean answerQuestionnaire(List<QuestionnaireAnswer> questionnaireAnswerList);
}
