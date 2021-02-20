package com.heaboy.service.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 问卷表
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_questionnaire")
public class Questionnaire extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 问卷ID
     */
    @TableField("questionarieId")
    private Long questionarieId;

    /**
     * 问卷题目
     */
    @TableField("questionarieTitle")
    private String questionarieTitle;

    /**
     * 问卷开始时间
     */
    @TableField("startTime")
    private LocalDateTime startTime;

    /**
     * 问卷截止时间
     */
    @TableField("endTime")
    private LocalDateTime endTime;

    /**
     * 问卷发布人ID
     */
    @TableField("creatorId")
    private Long creatorId;

    /**
     * 问卷创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
