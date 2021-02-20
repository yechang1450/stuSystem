package com.heaboy.service.course.entity;

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
@TableName("t_class_course_rule")
public class ClassCourseRule extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 班级课程表id
     */
    @TableField("classCourseId")
    private Long classCourseId;

    /**
     * 开始时间
     */
    @TableField("startTime")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField("endTime")
    private LocalDateTime endTime;

    /**
     * 节次数
     */
    @TableField("sectionNum")
    private Integer sectionNum;

    /**
     * 周次
     */
    @TableField("weekNum")
    private Integer weekNum;

    /**
     * 状态
     */
    private String status;

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

    /**
     * 班级号
     */
    @TableField("classNo")
    private String classNo;

    /**
     * 教师号,多个教师用#分割
     */
    @TableField("teachersNos")
    private String teachersNos;

    /**
     * 课程号
     */
    @TableField("courseNo")
    private String courseNo;


}
