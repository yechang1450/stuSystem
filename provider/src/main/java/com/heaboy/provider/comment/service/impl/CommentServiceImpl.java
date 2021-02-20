package com.heaboy.provider.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.comment.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.comment.mapper.CommentMapper;
import com.heaboy.service.comment.service.ICommentService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Override
    public IPage<Comment> index(Page<Comment> page ,Comment comment){

        QueryWrapper<Comment> queryWrapper = new QueryWrapper<Comment>();
        if(!ObjectUtils.isEmpty(comment.getStudentNo())) {
            queryWrapper = queryWrapper.like("studentNo",comment.getStudentNo());
        }
        if(!ObjectUtils.isEmpty(comment.getComment())) {
            queryWrapper = queryWrapper.like("comment",comment.getComment());
        }
        if(!ObjectUtils.isEmpty(comment.getPublicFlag())) {
            queryWrapper = queryWrapper.eq("publicFlag",comment.getPublicFlag());
        }
        if(!ObjectUtils.isEmpty(comment.getCareerFlag())) {
            queryWrapper = queryWrapper.like("careerFlag",comment.getCareerFlag());
        }
        if(!ObjectUtils.isEmpty(comment.getClassCourseActualld())) {
            queryWrapper = queryWrapper.like("classCourseActualld",comment.getClassCourseActualld());
        }
        if(!ObjectUtils.isEmpty(comment.getTopic())) {
            queryWrapper = queryWrapper.like("topic",comment.getTopic());
        }
        if(!ObjectUtils.isEmpty(comment.getCreateTime())) {
            queryWrapper = queryWrapper.like("createTime",comment.getCreateTime());
        }
        if(!ObjectUtils.isEmpty(comment.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",comment.getDeleteFlag());
        }
        IPage<Comment> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
