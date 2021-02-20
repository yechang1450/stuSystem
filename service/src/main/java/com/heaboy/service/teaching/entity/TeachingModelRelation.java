package com.heaboy.service.teaching.entity;

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
@TableName("t_teaching_model_relation")
public class TeachingModelRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 模块id
     */
    @TableField("modelId")
    private Integer modelId;

    /**
     * 模块项id
     */
    @TableField("modelOptionId")
    private Integer modelOptionId;

    /**
     * 状态
     */
    private String status;

    /**
     * 权重
     */
    private Double weight;


}
