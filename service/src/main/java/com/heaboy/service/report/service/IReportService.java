package com.heaboy.service.report.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.report.entity.Report;
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
public interface IReportService extends IService<Report> {

    /**
    *
    * @param page
    * @param report
    * @return
    */
    IPage<Report> index(Page<Report> page ,Report report);

}
