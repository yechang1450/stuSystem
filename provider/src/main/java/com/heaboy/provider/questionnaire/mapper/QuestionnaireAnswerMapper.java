package com.heaboy.provider.questionnaire.mapper;

import com.heaboy.service.questionnaire.entity.QuestionnaireAnswer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface QuestionnaireAnswerMapper extends BaseMapper<QuestionnaireAnswer> {

    /**
     * 向数据库中存入问卷的答案
     * @param questionnaireAnswerList
     * @return
     */
    int answerQuestionnaire(@Param("questionnaireAnswerList") List<QuestionnaireAnswer> questionnaireAnswerList);
}
