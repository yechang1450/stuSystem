package com.heaboy.service.teaching.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teaching.entity.Teaching;
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
public interface ITeachingService extends IService<Teaching> {

    /**
    *
    * @param page
    * @param teaching
    * @return
    */
    IPage<Teaching> index(Page<Teaching> page ,Teaching teaching);

}
