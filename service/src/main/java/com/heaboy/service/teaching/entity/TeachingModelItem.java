package com.heaboy.service.teaching.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import java.time.LocalDateTime;
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
@TableName("t_teaching_model_item")
public class TeachingModelItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 模板项名称
     */
    @TableField("modelItemName")
    private String modelItemName;

    /**
     * 模板项类别
     */
    @TableField("modelItemType")
    private String modelItemType;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建者id
     */
    @TableField("creatorId")
    private Long creatorId;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String reviser;

    /**
     * 修改时间
     */
    @TableField("reviseTime")
    private LocalDateTime reviseTime;

    /**
     * 使用次数
     */
    @TableField("usageCount")
    private Integer usageCount;


}
