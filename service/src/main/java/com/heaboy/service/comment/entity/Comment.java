package com.heaboy.service.comment.entity;

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
@TableName("t_comment")
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableField("studentNo")
    private String studentNo;

    /**
     * 内容
     */
    private String comment;

    /**
     * 默认 私有0
     */
    @TableField("publicFlag")
    private Boolean publicFlag;

    /**
     * 默认 同步1
     */
    @TableField("careerFlag")
    private Boolean careerFlag;

    /**
     * 可为空 默认-1
     */
    @TableField("classCourseActualld")
    private Long classCourseActualld;

    /**
     * 话题 默认-1
     */
    private String topic;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 是否删除
     */
    @TableField("deleteFlag")
    private Boolean deleteFlag;


}
