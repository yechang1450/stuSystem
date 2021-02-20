package com.heaboy.service.student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.student.entity.Student;
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
public interface IStudentService extends IService<Student> {

    /**
    *
    * @param page
    * @param student
    * @return
    */
    IPage<Student> index(Page<Student> page ,Student student);
    List<Student> listByClassNo(String classNo);
    Student insertSelective(Student student);
}
