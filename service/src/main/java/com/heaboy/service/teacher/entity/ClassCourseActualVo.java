package com.heaboy.service.teacher.entity;

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
 * @since 2021-02-02
 */
@Data
public class    ClassCourseActualVo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 教师编号
     */
    @TableField("teacherNoActual")
    private String teacherNoActual;
    /**
     * 教师姓名
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 班级上课规则id
     */
    @TableField("classCourseRulesId")
    private Long classCourseRulesId;

    /**
     * 班级号
     */
    @TableField("classNo")
    private String classNo;
    /**
     * 班级名称
     */
    @TableField("classNo")
    private String className;

    /**
     * 课程号
     */
    @TableField("courseNo")
    private String courseNo;
    /**
     * 课程名称
     */
    @TableField("courseNo")
    private String courseName;
    /**
     * 节次
     */
    @TableField("sectionNum")
    private int sectionNum;
    /**
     * 周次
     */
    @TableField("weekNum")
    private int weekNum;

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
     * 本次上课内容
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
