package com.heaboy.provider.questionnaire.mapper;

import com.heaboy.service.questionnaire.entity.QuestionnaireOption;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

/**
 * <p>
 * 选项表 Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface QuestionnaireOptionMapper extends BaseMapper<QuestionnaireOption> {

    int insert(List<QuestionnaireOption> questionnaireOptions);


    /**
     * 删除某问卷的某标题的全部选项
     * @param questionId
     * @param questionnaireId
     * @return
     */
    int deleteOption(@Param("questionId") Long questionId,@Param("questionnaireId") Long questionnaireId);

    /**
     * 查找某个问题对应的全部选项
     * @param questionnaireId
     * @param questionId
     * @return
     */
    List<QuestionnaireOption> selectOptions(@Param("questionnaireId") Long questionnaireId, @Param("questionId") Long questionId);

    /**
     * 删除问题的某一个选项
     * @param questionnaireOption
     * @return
     */
    int deleteQuestionOption(@Param("questionnaireOption") QuestionnaireOption questionnaireOption);

    /**
     *更新问题的选项的内容
     * @param questionnaireOption
     * @return
     */
    int updateQuestionOption(@Param("questionnaireOption") QuestionnaireOption questionnaireOption);

    /**
     * 插入某个问题的某个选项
     * @param questionnaireOption
     * @return
     */
    int InsertQuestionOption(@Param("questionnaireOption") QuestionnaireOption questionnaireOption);
}
