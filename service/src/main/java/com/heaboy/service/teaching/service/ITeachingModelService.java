package com.heaboy.service.teaching.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.TeachingModel;
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
public interface ITeachingModelService extends IService<TeachingModel> {

    /**
    *
    * @param page
    * @param teachingModel
    * @return
    */
    IPage<TeachingModel> index(Page<TeachingModel> page ,TeachingModel teachingModel);

}
