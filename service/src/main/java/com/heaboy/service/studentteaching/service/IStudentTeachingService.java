package com.heaboy.service.studentteaching.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.studentteaching.entity.StudentTeaching;
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
public interface IStudentTeachingService extends IService<StudentTeaching> {

    /**
    *
    * @param page
    * @param studentTeaching
    * @return
    */
    IPage<StudentTeaching> index(Page<StudentTeaching> page ,StudentTeaching studentTeaching);

}
