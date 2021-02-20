package com.heaboy.service.studentgrade.entity;

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
@TableName("t_student_grade")
public class StudentGrade extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableField("studentNo")
    private Long studentNo;

    /**
     * 课程号
     */
    @TableField("courseNo")
    private Long courseNo;

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

    @Override
    public String toString() {
        return "StudentGrade{" +
                "studentNo=" + studentNo +
                ", courseNo=" + courseNo +
                ", score=" + score +
                ", scorelevel=" + scorelevel +
                ", appraise='" + appraise + '\'' +
                ", usualGrades=" + usualGrades +
                ", usualWeight=" + usualWeight +
                ", testGrades=" + testGrades +
                ", testWeight=" + testWeight +
                ", grade=" + grade +
                ", isHang=" + isHang +
                ", classNo='" + classNo + '\'' +
                '}';
    }
}
