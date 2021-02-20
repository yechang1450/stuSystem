package com.heaboy.provider.teacher.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teacher.entity.ClassCourseActual;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heaboy.service.teacher.entity.ClassCourseActualVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-02
 */
public interface ClassCourseActualMapper extends BaseMapper<ClassCourseActual> {

    IPage<ClassCourseActualVo> selectPageInfo(Page<ClassCourseActualVo> page, @Param("courseActual") ClassCourseActual courseActual,@Param("userName") String userName);
}
