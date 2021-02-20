package com.heaboy.service.teaching.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.TeachingModelItem;
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
public interface ITeachingModelItemService extends IService<TeachingModelItem> {

    /**
    *
    * @param page
    * @param teachingModelItem
    * @return
    */
    IPage<TeachingModelItem> index(Page<TeachingModelItem> page ,TeachingModelItem teachingModelItem);

}
