package com.heaboy.service.stage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 阶段表
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_stage")
public class Stage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 阶段id
     */
    @TableField("stageId")
    private Integer stageId;

    /**
     * 阶段名字
     */
    @TableField("stageName")
    private String stageName;

    /**
     * 状态
     */
    private Integer status;


}
