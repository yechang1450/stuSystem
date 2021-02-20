package com.heaboy.provider.student.mapper;

import com.heaboy.service.student.entity.Student;
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
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> selectByClassNo(@Param("classNo") String classNo);

    long insertSelective(Student student);
}
