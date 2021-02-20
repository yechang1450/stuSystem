package com.heaboy.service.stage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.stage.entity.Stage;
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
public interface IStageService extends IService<Stage> {

    /**
    *
    * @param page
    * @param stage
    * @return
    */
    IPage<Stage> index(Page<Stage> page ,Stage stage);

}
