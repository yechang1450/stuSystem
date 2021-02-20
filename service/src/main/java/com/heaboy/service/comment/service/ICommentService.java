package com.heaboy.service.comment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.comment.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface ICommentService extends IService<Comment> {

    /**
    *
    * @param page
    * @param comment
    * @return
    */
    IPage<Comment> index(Page<Comment> page ,Comment comment);

}
