package com.heaboy.service.course.entity;

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
@TableName("t_course")
public class Course extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 课程编号
     */
    @TableField("courseNo")
    private String courseNo;

    /**
     * 课程名称
     */
    @TableField("courseName")
    private String courseName;

    /**
     * 学分
     */
    private Integer credit;

    /**
     * 学时
     */
    @TableField("classHours")
    private Integer classHours;

    /**
     * 课程介绍
     */
    private String introduction;

    /**
     * 开课目的
     */
    @TableField("coursePurpose")
    private String coursePurpose;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否删除
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;


}
