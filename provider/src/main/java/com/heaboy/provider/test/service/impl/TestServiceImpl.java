package com.heaboy.provider.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.test.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.test.mapper.TestMapper;
import com.heaboy.service.test.service.ITestService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-01-26
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Override
    public IPage<Test> index(Page<Test> page ,Test test){

        QueryWrapper<Test> queryWrapper = new QueryWrapper<Test>();
//        if(!ObjectUtils.isEmpty(test.getUserName())) {
//            queryWrapper = queryWrapper.like("user_name",test.getUserName());
//        }
//        if(!ObjectUtils.isEmpty(test.getAccount())) {
//            queryWrapper = queryWrapper.like("account",test.getAccount());
//        }
//        if(!ObjectUtils.isEmpty(test.getPwd())) {
//            queryWrapper = queryWrapper.like("pwd",test.getPwd());
//        }
//        if(!ObjectUtils.isEmpty(test.getProfessionCode())) {
//            queryWrapper = queryWrapper.like("profession_code",test.getProfessionCode());
//        }
//        if(!ObjectUtils.isEmpty(test.getIcon())) {
//            queryWrapper = queryWrapper.like("icon",test.getIcon());
//        }
//        if(!ObjectUtils.isEmpty(test.getStatus())) {
//            queryWrapper = queryWrapper.like("status",test.getStatus());
//        }
//        if(!ObjectUtils.isEmpty(test.getDeleteStatus())) {
//            queryWrapper = queryWrapper.like("delete_status",test.getDeleteStatus());
//        }
        IPage<Test> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
