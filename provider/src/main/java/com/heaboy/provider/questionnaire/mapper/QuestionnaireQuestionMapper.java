package com.heaboy.provider.questionnaire.mapper;

import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 问题表 Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface QuestionnaireQuestionMapper extends BaseMapper<QuestionnaireQuestion> {

    /**
     * 删除某问卷的某道题
     * @param questionId
     * @param questionnaireId
     * @return
     */
    int deleteQuestion(@Param("questionId") Long questionId, @Param("questionnaireId") Long questionnaireId);

    /**
     * 查询某问卷的所有的题目
     * @param questionnaireId
     * @return
     */
    List<QuestionnaireQuestion> selectQuestions(@Param("questionnaireId") Long questionnaireId);

    /**
     * 更新问题的标题
     * @param questionnaireQuestion
     * @return
     */
    int updateQuestion(@Param("questionnaireQuestion") QuestionnaireQuestion questionnaireQuestion);

    Long into(QuestionnaireQuestion questionnaireQuestion);

}
