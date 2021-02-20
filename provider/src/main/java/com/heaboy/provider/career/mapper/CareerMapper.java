package com.heaboy.provider.career.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.career.entity.Career;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heaboy.service.career.entity.CareerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface CareerMapper extends BaseMapper<Career> {

    IPage<CareerVo> selectPageInfo(Page<CareerVo> page, @Param("career") Career career,@Param("userName")  String userName);

    boolean updateDeleteFlagById(List<Long> ids,@Param("deleteFlagYes") Integer deleteFlagYes);
}
