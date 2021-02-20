package com.heaboy.service.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.test.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-01-26
 */
public interface ITestService extends IService<Test> {

    /**
    *
    * @param page
    * @param test
    * @return
    */
    IPage<Test> index(Page<Test> page ,Test test);

}
