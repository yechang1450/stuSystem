package com.heaboy.provider.studentgrade.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.studentgrade.entity.StudentGrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heaboy.service.studentgrade.entity.StudentGradeVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface StudentGradeMapper extends BaseMapper<StudentGrade> {

    IPage<StudentGradeVo> selectPageInfo(Page<StudentGradeVo> page, @Param("studentGrade") StudentGrade studentGrade,@Param("userName") String userName);
}
