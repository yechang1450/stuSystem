package com.heaboy.service.teaching.entity;

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
@TableName("t_teaching")
public class Teaching extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
    @TableField("classId")
    private Integer classId;

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
     * 模块id
     */
    @TableField("modelId")
    private Integer modelId;

    /**
     * 教师总评分
     */
    @TableField("teacherTotalScore")
    private Double teacherTotalScore;

    /**
     * 状态
     */
    private String status;

    /**
     * 评教开始时间
     */
    @TableField("teachingStartTime")
    private LocalDateTime teachingStartTime;

    /**
     * 评教结束时间
     */
    @TableField("teachingEndTime")
    private LocalDateTime teachingEndTime;

    /**
     * 创建者id
     */
    @TableField("creatorId")
    private Long creatorId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
