package com.heaboy.service.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 问题表
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_questionnaire_question")
public class QuestionnaireQuestion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    @TableField("questionId")
    private Long questionId;

    /**
     * 问题题目
     */
    @TableField("questionTitle")
    private String questionTitle;

    /**
     * 问题类型
     */
    @TableField("questionType")
    private String questionType;

    /**
     * 问卷ID
     */
    @TableField("questionaireId")
    private Long questionaireId;

    /**
     * 问题对应的选项
     */
    @TableField(exist = false)
    private List<QuestionnaireOption> questionnaireOptionList;

    /**
     * 每个问题对应的答案
     */
    @TableField(exist = false)
    private String answer;

    @TableField(exist = false)
    private String[] duoxuankuang;


}
