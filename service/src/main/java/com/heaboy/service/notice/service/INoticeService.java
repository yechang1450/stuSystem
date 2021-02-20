package com.heaboy.service.notice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.notice.entity.Notice;
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
public interface INoticeService extends IService<Notice> {

    /**
    *
    * @param page
    * @param notice
    * @return
    */
    IPage<Notice> index(Page<Notice> page ,Notice notice);

}
