package com.heaboy.service.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author heaboy
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_test")
public class Test extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String userName;


    private LocalDateTime startTime;

}
