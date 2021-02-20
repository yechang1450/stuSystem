package com.heaboy.service.career.entity;

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
@TableName("t_career")
public class Career extends BaseEntity {

    private static final long serialVersionUID = 1L;
    //删除标志,已删除
    public static final Integer DELETE_FLAG_YES = 1;
    //删除标志,未删除
    public static final Integer DELETE_FLAG_NO = 0;
    //下面常量按照文档所写
    //系统事件
    public static final Integer EVENT_TYPE_SYSTEM = 0;
    //奖励事件
    public static final Integer EVENT_TYPE_REWARD = 1;
    //惩罚事件
    public static final Integer EVENT_TYPE_PUNISHMENT = 2;
    //学生自定义事件
    public static final Integer EVENT_TYPE_DIY = 10;


    /**
     * 学号
     */
    @TableField("studentNo")
    private String studentNo;

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
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
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
