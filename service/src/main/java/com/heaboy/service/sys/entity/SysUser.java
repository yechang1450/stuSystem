package com.heaboy.service.sys.entity;

import com.heaboy.common.common.entity.BaseEntity;
import java.time.LocalDateTime;
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
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createtime;

    private String password;

    private LocalDateTime updatetime;

    private String username;

    private Boolean available;

    private String email;

    private String tel;

    /**
     * 性别(0.男,1.女)
     */
    private Integer sexType;

    private Boolean first;


}
