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
public class SysRoleResources extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long sysRoleId;

    private Long resourcesId;


}
