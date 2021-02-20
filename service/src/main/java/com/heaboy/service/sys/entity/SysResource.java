package com.heaboy.service.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.heaboy.common.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

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
public class SysResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Boolean available;

    private String name;

    private Integer orderNum;

    private String permission;

    private Integer type;

    private String url;

    private Long parentId;

    @TableField(exist=false)
    private List<SysResource> childResources;

    public static enum ResourceType {

        menu("菜单"), button("按钮");

        private final String info;

        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

}
