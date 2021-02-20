package com.heaboy.service.studentteaching.entity;

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
@TableName("t_student_teaching")
public class StudentTeaching extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableField("studentNo")
    private String studentNo;

    /**
     * 评教id
     */
    @TableField("teachingId")
    private Integer teachingId;

    /**
     * 评教模板项id
     */
    @TableField("teachingModelId")
    private Integer teachingModelId;

    /**
     * 评教分值
     */
    @TableField("teachingFraction")
    private String teachingFraction;

    /**
     * 评教文字内容
     */
    @TableField("teachingContent")
    private String teachingContent;

    /**
     * 评教时间
     */
    @TableField("teachingTime")
    private LocalDateTime teachingTime;

    /**
     * 是否已阅
     */
    @TableField("whetherRead")
    private String whetherRead;

    /**
     * 评教模板项类别
     */
    @TableField("teachingType")
    private String teachingType;

    /**
     * 科目id
     */
    @TableField("subjectId")
    private Integer subjectId;

    /**
     * 教师id
     */
    @TableField("teacherId")
    private Integer teacherId;

    /**
     * 班级id
     */
    @TableField("classId")
    private Integer classId;


}
