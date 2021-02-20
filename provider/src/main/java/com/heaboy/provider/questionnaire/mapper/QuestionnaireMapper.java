package com.heaboy.provider.questionnaire.mapper;

import com.heaboy.service.questionnaire.entity.Questionnaire;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 问卷表 Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {

    int updateByid(Questionnaire questionnaire);

    /**
     * 通过id查找问卷的实体类对象
     * @param questionnaireId
     * @return
     */
    Questionnaire selectQuestionnaireById(@Param("questionnaireId") Long questionnaireId);

}
