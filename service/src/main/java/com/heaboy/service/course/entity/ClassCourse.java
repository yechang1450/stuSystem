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
@TableName("t_class_course")
public class ClassCourse extends BaseEntity {

    private static final long serialVersionUID = 1L;
    //学生及格线
    public static final double IS_HANG = 60;
    //不及格
    public static final int NOT_HANG = 0;
    //及格
    public static final int HANG = 1;


    /**
     * 班级号
     */
    @TableField("classNo")
    private String classNo;

    /**
     * 老师号
     */
    @TableField("teacherNos")
    private String teacherNos;

    /**
     * 课程号
     */
    @TableField("courseNo")
    private String courseNo;

    /**
     * 平时成绩权重
     */
    @TableField("usualWeight")
    private Double usualWeight;

    /**
     * 考试成绩权重
     */
    @TableField("testWeight")
    private Double testWeight;

    /**
     * 剩余学时
     */
    @TableField("classHoursLeft")
    private Integer classHoursLeft;

    /**
     * 0 :开课 1:结课
     */
    private Integer status;

    /**
     * 删除状态 0:未删除 1删除
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;


}
