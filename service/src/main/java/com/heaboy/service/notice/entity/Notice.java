package com.heaboy.service.notice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.heaboy.common.common.entity.BaseEntity;
import java.time.LocalDateTime;
import java.sql.Blob;
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
@TableName("t_notice")
public class Notice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 发布人编号
     */
    private String publisherld;

    /**
     * 作者
     */
    private String author;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 公告种类
     */
    private Integer type;

    /**
     * 是否置顶
     */
    @TableField("isTop")
    private Boolean isTop;

    /**
     * 是否轮播播放
     */
    @TableField("isHot")
    private Boolean isHot;

    /**
     * 公告标题
     */
    @TableField("contentTitle")
    private String contentTitle;

    /**
     * 内容
     */
    @TableField("contentText")
    private String contentText;


}
