package com.heaboy.provider.career.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.career.entity.Career;
import com.heaboy.provider.career.mapper.CareerMapper;
import com.heaboy.service.career.entity.CareerVo;
import com.heaboy.service.career.service.ICareerService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;
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
public class CareerServiceImpl extends ServiceImpl<CareerMapper, Career> implements ICareerService {

    @Override
    public IPage<Career> index(Page<Career> page ,Career career){

        QueryWrapper<Career> queryWrapper = new QueryWrapper<Career>();
        if(!ObjectUtils.isEmpty(career.getStudentNo())) {
            queryWrapper = queryWrapper.like("studentNo",career.getStudentNo());
        }
        if(!ObjectUtils.isEmpty(career.getTimePoint())) {
            queryWrapper = queryWrapper.like("timePoint",career.getTimePoint());
        }
        if(!ObjectUtils.isEmpty(career.getEventTitle())) {
            queryWrapper = queryWrapper.like("eventTitle",career.getEventTitle());
        }
        if(!ObjectUtils.isEmpty(career.getEvent())) {
            queryWrapper = queryWrapper.like("event",career.getEvent());
        }
        if(!ObjectUtils.isEmpty(career.getEventType())) {
            queryWrapper = queryWrapper.like("eventType",career.getEventType());
        }
        if(!ObjectUtils.isEmpty(career.getRemarks())) {
            queryWrapper = queryWrapper.like("remarks",career.getRemarks());
        }
        if(!ObjectUtils.isEmpty(career.getCreatetime())) {
            queryWrapper = queryWrapper.like("createtime",career.getCreatetime());
        }
        if(!ObjectUtils.isEmpty(career.getStatus())) {
            queryWrapper = queryWrapper.like("status",career.getStatus());
        }
        if(!ObjectUtils.isEmpty(career.getDeleteFlag())) {
            queryWrapper = queryWrapper.like("deleteFlag",career.getDeleteFlag());
        }
        if(!ObjectUtils.isEmpty(career.getCreatorld())) {
            queryWrapper = queryWrapper.like("creatorld",career.getCreatorld());
        }
        IPage<Career> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public IPage<CareerVo> indexPage(Page<CareerVo> page, Career career, String userName) {
        return getBaseMapper().selectPageInfo(page,career,userName);
    }

    @Override
    public boolean saveCareer(Career career, long userId) {
        career.setCreatetime(LocalDateTime.now());
        career.setDeleteFlag(Career.DELETE_FLAG_NO);
        career.setCreatorld(userId);
        return this.save(career);
    }

    @Override
    public boolean removeByCareerId(Long id) {
        Career career = getById(id);
        career.setDeleteFlag(Career.DELETE_FLAG_YES);
        return this.updateById(career);
    }

    @Override
    public boolean removeByCareerIds(List<Long> ids) {
        return getBaseMapper().updateDeleteFlagById(ids,Career.DELETE_FLAG_YES);
    }
}
