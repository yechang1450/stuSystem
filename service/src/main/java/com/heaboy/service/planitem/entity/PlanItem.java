package com.heaboy.service.planitem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

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
@TableName("t_plan_item")
public class PlanItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("userNo")
    private String userNo;

    /**
     * 计划做的事
     */
    private String item;

    /**
     * 开始时间
     */
    @TableField("startTime")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField("endTime")
    private LocalDateTime endTime;

    /**
     * 0 既不重要也不紧急的   1 重要单不紧急 2 :紧急但不重要 3 重要且紧急的
     */
    private Integer priority;

    /**
     * 1完成  0未完成
     */
    private Boolean status;

    /**
     * 事项标题
     */
    @TableField("itemTitle")
    private String itemTitle;

    /**
     * 事项类别 0系统 1自己添加的 2其他人添加的
     */
    @TableField("itemType")
    private Integer itemType;

    /**
     * 父项Id
     */
    @TableField("parentId")
    private Long parentId;

    /**
     * 是否删除
     */
    @TableField("deleteFlag")
    private Boolean deleteFlag;

    /**
     * 创建者Id
     */
    @TableField("creatorId")
    private Long creatorId;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private List<PlanItem> childPlanItems;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
