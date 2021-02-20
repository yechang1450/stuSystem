package com.heaboy.service.career.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Data
public class CareerVo extends BaseEntity {

    /**
     * 学号
     */
    @TableField("studentNo")
    private String studentNo;
    /**
     * 学生姓名
     */
    @TableField(exist = false)
    private String studentName;
    /**
     * 所属班级
     */
    @TableField(exist = false)
    private String classNo;
    /**
     * 所属班级
     */
    @TableField(exist = false)
    private String className;

    /**
     * 记录时间点
     */
    @TableField("timePoint")
    private LocalDateTime timePoint;

    /**
     * 事件标题
     */
    @TableField("eventTitle")
    private String eventTitle;

    /**
     * 事件内容
     */
    private String event;

    /**
     * 事件类别0 系统事件,1 奖励事件 2 惩罚事件,迟到 早退 10 学生自行添加
0 系统事件,1 奖励事件 2 惩罚事件,迟到 早退 10 学生自行添加

     */
    @TableField("eventType")
    private Integer eventType;

    /**
     * 事件类别名称

     */
    @TableField(exist = false)
    private Integer eventTypeName;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否删除
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;

    /**
     * 创建者id 


     */
    private Long creatorld;


}
