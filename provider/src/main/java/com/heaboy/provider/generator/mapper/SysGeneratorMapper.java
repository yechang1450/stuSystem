package com.heaboy.provider.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heaboy.service.generator.entity.SysGenerator;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @since 2019-04-15
 */
public interface SysGeneratorMapper extends BaseMapper<SysGenerator> {

    /**
     * @Date 11:40 2019/4/16
     * @return java.util.List<java.lang.String>
     **/
    List<String> getTables();
}
