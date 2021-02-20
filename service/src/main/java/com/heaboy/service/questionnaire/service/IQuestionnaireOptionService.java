package com.heaboy.service.questionnaire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.questionnaire.entity.QuestionnaireOption;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface IQuestionnaireOptionService extends IService<QuestionnaireOption> {

    /**
    *
    * @param page
    * @param questionnaireOption
    * @return
    */
    IPage<QuestionnaireOption> index(Page<QuestionnaireOption> page ,QuestionnaireOption questionnaireOption);

    int insert(List<QuestionnaireOption>questionnaireOptions);

    /**
     *查询某个问题的全部的选项
     * @param questionnaireId
     * @param questionId
     */
    List<QuestionnaireOption> selectOptions(Long questionnaireId, Long questionId);

    /**
     * 删除问题的某个选项
     * @param questionnaireOption
     * @return
     */
    boolean deleteQuestionOption(QuestionnaireOption questionnaireOption);

    /**
     * 插入某个问题的某一个选项
     * @param questionnaireOption
     * @return
     */
    boolean InsertQuestionOption(QuestionnaireOption questionnaireOption);
}
