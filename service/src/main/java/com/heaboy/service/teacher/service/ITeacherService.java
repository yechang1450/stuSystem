package com.heaboy.service.teacher.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.teacher.entity.Teacher;
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
public interface ITeacherService extends IService<Teacher> {

    /**
    *
    * @param page
    * @param teacher
    * @return
    */
    IPage<Teacher> index(Page<Teacher> page ,Teacher teacher);

}
