package com.heaboy.service.questionnaire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface IQuestionnaireQuestionService extends IService<QuestionnaireQuestion> {

    /**
    *
    * @param page
    * @param questionnaireQuestion
    * @return
    */
    IPage<QuestionnaireQuestion> index(Page<QuestionnaireQuestion> page ,QuestionnaireQuestion questionnaireQuestion);


    Long insert(QuestionnaireQuestion questionnaireQuestion);

    /**
     *
     * @param questionId
     * @param questionnaireId
     * @return
     */
    boolean deleteQuestion(Long questionId, Long questionnaireId);

    /**
     *查询某问卷的所有的对应的题目
     * @param questionnaireId
     * @return
     */
    List<QuestionnaireQuestion> selectQuestions(Long questionnaireId);

    /**
     * 更新某个问题包括问题选项
     * @param questionnaireQuestion
     * @return
     */
    boolean updateQuestion(QuestionnaireQuestion questionnaireQuestion);

}
