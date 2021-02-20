package com.heaboy.service.teacher.entity;

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
@TableName("t_teacher")
public class Teacher extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 教师编号
     */
    @TableField("teacherNo")
    private String teacherNo;

    /**
     * 老师名
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 是否是班主任  true 是 false 否
     */
    @TableField("headFlag")
    private Integer headFlag;

    /**
     * 性别true男false女
     */
    private Integer sex;

    /**
     * 0教师
     */
    @TableField("teacherTypeID")
    private Integer teacherTypeID;

    /**
     * 例:年度最佳教师×1
     */
    private String honor;

    /**
     * 0:在职 1:离职 2:休假
     */
    private Integer status;

    /**
     * 删除标识 0未删除 1删除
     */
    @TableField("deleteFlag")
    private Integer deleteFlag;


}
