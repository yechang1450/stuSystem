package com.heaboy.service.classname.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.classname.entity.ClassName;
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
public interface IClassNameService extends IService<ClassName> {

    /**
    *
    * @param page
    * @param className
    * @return
    */
    IPage<ClassName> index(Page<ClassName> page ,ClassName className);

    List<ClassName> listByTeacherNo(String userName);
}
