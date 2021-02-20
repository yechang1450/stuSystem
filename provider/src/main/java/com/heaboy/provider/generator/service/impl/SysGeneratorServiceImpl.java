package com.heaboy.provider.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.provider.generator.CodeGenerator;
import com.heaboy.service.generator.entity.SysGenerator;
import com.heaboy.provider.generator.mapper.SysGeneratorMapper;
import com.heaboy.service.generator.service.ISysGeneratorService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;


import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2019-04-15
 */
@Service
public class SysGeneratorServiceImpl extends ServiceImpl<SysGeneratorMapper, SysGenerator> implements ISysGeneratorService {
    @Override
    public List<String> getTables() {
        return getBaseMapper().getTables();
    }

    @Override
    public void createCode(String moduleName, String tableName, String ignoreFlag, String ignorePrefix, String isRest
            ,String projectName) {
        try {
            CodeGenerator.createCode(moduleName,tableName,ignoreFlag,ignorePrefix,isRest,projectName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IPage<SysGenerator> index(Page<SysGenerator> page, SysGenerator sysGenerator) {
        QueryWrapper<SysGenerator> queryWrapper = new QueryWrapper<SysGenerator>();

        if(!ObjectUtils.isEmpty(sysGenerator.getModuleName())) {
            queryWrapper = queryWrapper.like("moduleName",sysGenerator.getModuleName());
         }
        if(!ObjectUtils.isEmpty(sysGenerator.getTableName())) {
            queryWrapper = queryWrapper.like("tableName",sysGenerator.getTableName());
         }
        IPage<SysGenerator> pageInfo = page(page, queryWrapper);
        return  pageInfo;
    }
}
