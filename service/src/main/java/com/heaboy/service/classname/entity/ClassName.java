package com.heaboy.service.classname.entity;

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
@TableName("t_class_name")
public class ClassName extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 班级编号
     */
    @TableField("classNo")
    private String classNo;

    /**
     * 班级名
     */
    @TableField("className")
    private String className;

    /**
     * 正常新班级/补课班级
     */
    private String type;

    /**
     * 班主任编号
     */
    @TableField("headTeacherId")
    private String headTeacherId;

    /**
     * 班主任姓名
     */
    @TableField("headTeacherName")
    private String headTeacherName;

    /**
     * 是否毕业  0未毕业 1毕业
     */
    @TableField("isGraduation")
    private Boolean isGraduation;

    /**
     * 阶段id
     */
    @TableField("stageId")
    private Long stageId;

    /**
     * 班级人数
     */
    @TableField("studentNumber")
    private Integer studentNumber;

    /**
     * qq群号
     */
    @TableField("qqGroupNumber")
    private String qqGroupNumber;

    /**
     * qq群二维码
     */
    @TableField("qqGroup")
    private String qqGroup;

    /**
     * 微信群二维码
     */
    @TableField("wechatGroup")
    private String wechatGroup;

    /**
     * 是否删除 1删除 0未删除
     */
    @TableField("deleteFlag")
    private Boolean deleteFlag;

    /**
     * 创建者id
     */
    @TableField("creatorId")
    private Long creatorId;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 创建者名称
     */
    private String creater;


}
