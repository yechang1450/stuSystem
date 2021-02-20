package com.heaboy.service.questionnaire.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_questionnaire_answer")
public class QuestionnaireAnswer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableField("userId")
    private Long userId;

    /**
     * 问卷编号
     */
    @TableField("questionnaireId")
    private Long questionnaireId;

    /**
     * 问题编号
     */
    @TableField("questionId")
    private Long questionId;

    /**
     * 答案内容
     */
    private String answer;

    /**
     * 问卷填写所耗时间
     */
    @TableField("operateTime")
    private BigDecimal operateTime;


}
