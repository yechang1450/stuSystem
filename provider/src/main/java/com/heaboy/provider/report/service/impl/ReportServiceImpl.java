package com.heaboy.provider.report.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.report.entity.Report;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.report.mapper.ReportMapper;
import com.heaboy.service.report.service.IReportService;
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
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements IReportService {

    @Override
    public IPage<Report> index(Page<Report> page ,Report report){

        QueryWrapper<Report> queryWrapper = new QueryWrapper<Report>();
        if(!ObjectUtils.isEmpty(report.getStudentNo())) {
            queryWrapper = queryWrapper.like("studentNo",report.getStudentNo());
        }
        if(!ObjectUtils.isEmpty(report.getClassCourseActualled())) {
            queryWrapper = queryWrapper.like("classCourseActualled",report.getClassCourseActualled());
        }
        if(!ObjectUtils.isEmpty(report.getReportTime())) {
            queryWrapper = queryWrapper.like("reportTime",report.getReportTime());
        }
        if(!ObjectUtils.isEmpty(report.getStudentReportTime())) {
            queryWrapper = queryWrapper.like("studentReportTime",report.getStudentReportTime());
        }
        if(!ObjectUtils.isEmpty(report.getReportStatus())) {
            queryWrapper = queryWrapper.like("reportStatus",report.getReportStatus());
        }
        IPage<Report> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
