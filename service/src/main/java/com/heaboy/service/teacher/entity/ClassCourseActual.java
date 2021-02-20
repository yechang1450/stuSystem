package com.heaboy.service.teacher.entity;

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
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_class_course_actual")
public class ClassCourseActual extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 教师编号
     */
    @TableField("teacherNoActual")
    private String teacherNoActual;

    /**
     * 班级上课规则id
     */
    @TableField("classCourseRulesId")
    private Long classCourseRulesId;

    /**
     * 班级课程表id
     */
    @TableField("classCourseId")
    private Long classCourseId;

    /**
     * 班级号
     */
    @TableField("classNo")
    private String classNo;

    /**
     * 课程号
     */
    @TableField("courseNo")
    private String courseNo;

    /**
     * 开始时间
     */
    @TableField("startTime")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField("endTIme")
    private LocalDateTime endTIme;

    /**
     * 本次预习内容
     */
    @TableField("courseContent")
    private String courseContent;

    /**
     * 预习
     */
    private String preview;

    /**
     * 课后作业
     */
    private String homework;

    /**
     * 是否删除
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;

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


}
