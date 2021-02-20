package com.heaboy.provider.course.mapper;

import com.heaboy.service.course.entity.ClassCourseRule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heaboy.service.course.entity.ClassNameVo;
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
public interface ClassCourseRuleMapper extends BaseMapper<ClassCourseRule> {

    List<ClassNameVo> selectCourseByClassNoAndUserName(@Param("classNo") String classNo,@Param("userName") String userName);

    List<ClassNameVo> selectCourseByUserName(@Param("userName")String userName);
}
