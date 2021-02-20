package com.heaboy.service.generator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.service.generator.entity.SysGenerator;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2019-04-15
 */
public interface ISysGeneratorService extends IService<SysGenerator> {

    /**
     * @Date 11:21 2019/4/16
     * @return java.util.List<java.lang.String>
     **/
    List<String> getTables();

    /**
     *
     * @param moduleName
     * @param tableName
     * @param ignoreFlag
     * @param ignorePrefix
     * @param isRest
     */
    void createCode(String moduleName, String tableName,
                    String ignoreFlag,  String ignorePrefix,
                    String isRest,String projectName);

    /**
     *
     * @param page
     * @param sysGenerator
     * @return
     */
    IPage<SysGenerator> index(Page<SysGenerator> page, SysGenerator sysGenerator);
}
