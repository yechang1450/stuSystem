package com.heaboy.service.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 选项表
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_questionnaire_option")
public class QuestionnaireOption extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 选项编号
     */
    @TableField("optionId")
    private Long optionId;

    /**
     * 问题编号
     */
    @TableField("questionId")
    private Long questionId;

    /**
     * 问卷编号
     */
    @TableField("questionnaireId")
    private Long questionnaireId;

    /**
     * 选项的内容
     */
    @TableField("optionContent")
    private String optionContent;


}
