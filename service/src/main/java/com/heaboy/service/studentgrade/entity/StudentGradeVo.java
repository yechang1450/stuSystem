package com.heaboy.service.studentgrade.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.heaboy.common.common.entity.BaseEntity;
import lombok.Data;

@Data
public class StudentGradeVo extends BaseEntity {
    /**
     * 学生id
     */
    @TableField("studentNo")
    private Long studentNo;
    /**
     * 学生姓名
     */
    @TableField(value = "studentName",exist = false)
    private String studentName;

    /**
     * 课程号
     */
    @TableField("courseNo")
    private Long courseNo;

    /**
     * 课程名称
     */
    @TableField(value = "courseName",exist = false)
    private String courseName;

    /**
     * 分数
     */
    private Long score;

    /**
     * 1差2及格3良4优秀5满分
     */
    private Integer scorelevel;

    /**
     * 评语
     */
    private String appraise;

    /**
     * 平时成绩
     */
    @TableField("usualGrades")
    private Double usualGrades;

    /**
     * 平时成绩权重
     */
    @TableField("usualWeight")
    private Double usualWeight;

    /**
     * 考试成绩
     */
    @TableField("testGrades")
    private Double testGrades;

    /**
     * 考试成绩权重
     */
    @TableField("testWeight")
    private Double testWeight;

    /**
     * 总成绩
     */
    private Double grade;

    /**
     * 是否挂科
     */
    @TableField("isHang")
    private Integer isHang;

    /**
     * 班级号
     */
    @TableField("classNo")
    private String classNo;
    /**
     * 班级名称
     */
    @TableField(value = "className",exist = false)
    private String className;

}
