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
@TableName("t_teacher_type")
public class TeacherType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 教师类别名称
     */
    @TableField("teacherTypeName")
    private String teacherTypeName;


}
