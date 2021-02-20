package com.heaboy.service.student.entity;

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
@TableName("t_student")
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableField("studentNo")
    private String studentNo;

    /**
     * 学生姓名
     */
    @TableField("studentName")
    private String studentName;

    /**
     * 班级编号
     */
    @TableField("classNo")
    private Long classNo;

    /**
     * 男/女/保密
     */
    private Integer sex;

    /**
     * 手机号
     */
    @TableField("phoneNumber")
    private String phoneNumber;

    /**
     * 所处阶段
     */
    @TableField("stageId")
    private Integer stageId;

    /**
     * 学生状态
     */
    private Integer status;

    /**
     * 推荐人的推荐码
     */
    @TableField("recommendCode")
    private String recommendCode;

    /**
     * 自己的推荐码
     */
    @TableField("selfrecommendCode")
    private String selfrecommendCode;

    /**
     * 迟到次数
     */
    @TableField("lateTimes")
    private Integer lateTimes;

    /**
     * 缺勤次数
     */
    @TableField("truancyTimes")
    private Integer truancyTimes;

    /**
     * 工作去向
     */
    private String workplace;

    /**
     * 个性签名
     */
    @TableField("personalSignature")
    private String personalSignature;


}
