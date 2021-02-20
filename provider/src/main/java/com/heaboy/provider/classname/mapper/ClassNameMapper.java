package com.heaboy.provider.classname.mapper;

import com.heaboy.service.classname.entity.ClassName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ClassNameMapper extends BaseMapper<ClassName> {

    List<ClassName> selectByTeacherNo(@Param("TeacherNo") String TeacherNo);
}
