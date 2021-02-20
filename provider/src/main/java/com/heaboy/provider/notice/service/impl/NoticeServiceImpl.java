package com.heaboy.provider.notice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.notice.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.notice.mapper.NoticeMapper;
import com.heaboy.service.notice.service.INoticeService;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Override
    public IPage<Notice> index(Page<Notice> page ,Notice notice){

        QueryWrapper<Notice> queryWrapper = new QueryWrapper<Notice>();
        if(!ObjectUtils.isEmpty(notice.getPublisherld())) {
            queryWrapper = queryWrapper.like("publisherld",notice.getPublisherld());
        }
        if(!ObjectUtils.isEmpty(notice.getAuthor())) {
            queryWrapper = queryWrapper.like("author",notice.getAuthor());
        }
        if(!ObjectUtils.isEmpty(notice.getType())) {
            queryWrapper = queryWrapper.like("type",notice.getType());
        }
        if(!ObjectUtils.isEmpty(notice.getIsTop())) {
            queryWrapper = queryWrapper.like("isTop",notice.getIsTop());
        }
        if(!ObjectUtils.isEmpty(notice.getIsHot())) {
            queryWrapper = queryWrapper.like("isHot",notice.getIsHot());
        }
        if(!ObjectUtils.isEmpty(notice.getContentTitle())) {
            queryWrapper = queryWrapper.like("contentTitle",notice.getContentTitle());
        }
        if(!ObjectUtils.isEmpty(notice.getContentText())) {
            queryWrapper = queryWrapper.like("contentText",notice.getContentText());
        }
        IPage<Notice> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
