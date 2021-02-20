package com.heaboy.service.career.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.career.entity.Career;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.service.career.entity.CareerVo;

import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface ICareerService extends IService<Career> {

    /**
    *
    * @param page
    * @param career
    * @return
    */
    IPage<Career> index(Page<Career> page ,Career career);

    IPage<CareerVo> indexPage(Page<CareerVo> page, Career career, String userName);

    boolean saveCareer(Career career, long userId);

    boolean removeByCareerId(Long id);

    boolean removeByCareerIds(List<Long> ids);
}
