package com.heaboy.service.teaching.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.TeachingModelRelation;
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
public interface ITeachingModelRelationService extends IService<TeachingModelRelation> {

    /**
    *
    * @param page
    * @param teachingModelRelation
    * @return
    */
    IPage<TeachingModelRelation> index(Page<TeachingModelRelation> page ,TeachingModelRelation teachingModelRelation);

}
