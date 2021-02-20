package com.heaboy.service.sys.entity;

import com.heaboy.common.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public static  final  long CODE_ADMIN_ROLE=1;
    public static  final  long CODE_BASE_ROLE=2;
    public static  final  long CODE_TEACHER_ROLE=3;
    public static  final  long CODE_STUDENT_ROLE=4;
    private Boolean available;

    private String description;

    private String name;


}
