package com.heaboy.service.report.entity;

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
@TableName("t_report")
public class Report extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableField("studentNo")
    private String studentNo;

    /**
     * 实际上课Id
     */
    @TableField("classCourseActualled")
    private Long classCourseActualled;

    /**
     * 打卡时间
     */
    @TableField("reportTime")
    private LocalDateTime reportTime;

    /**
     * 实际打卡时间
     */
    @TableField("studentReportTime")
    private LocalDateTime studentReportTime;

    /**
     * 打卡状态
     */
    @TableField("reportStatus")
    private Integer reportStatus;



}
