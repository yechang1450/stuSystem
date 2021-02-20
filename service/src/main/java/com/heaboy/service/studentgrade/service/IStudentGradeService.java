package com.heaboy.service.studentgrade.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.studentgrade.entity.StudentGrade;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.service.studentgrade.entity.StudentGradeVo;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface IStudentGradeService extends IService<StudentGrade> {

    /**
    *
    * @param page
    * @param studentGrade
    * @return
    */
    IPage<StudentGrade> index(Page<StudentGrade> page ,StudentGrade studentGrade);

    boolean saveScore(StudentGrade studentGrade);

    boolean updateScore(StudentGrade studentGrade);

    IPage<StudentGradeVo> indexPage(Page<StudentGradeVo> page, StudentGrade studentGrade, String userName);
}
