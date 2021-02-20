package com.heaboy.service.relation.entity;

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
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user_bind")
public class UserBind extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public static  final int CODE_STUDENT=1;
    public static  final int CODE_TEACHER=2;

    /**
     * 学生或者教师账户
     */
    @TableField("userNo")
    private String userNo;

    /**
     * sys_user表中的id
     */
    @TableField("sysUserId")
    private Long sysUserId;

    /**
     * 1 : 学生 2 教师
     */
    private Integer type;


}
