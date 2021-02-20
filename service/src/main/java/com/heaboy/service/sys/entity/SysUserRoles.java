package com.heaboy.service.sys.entity;

import com.heaboy.common.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author heaboy
 * @since 2021-01-25
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class SysUserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long sysUserId;

    private Long rolesId;


}
