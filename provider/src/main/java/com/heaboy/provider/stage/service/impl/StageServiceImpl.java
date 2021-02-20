package com.heaboy.provider.stage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.stage.entity.Stage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.stage.mapper.StageMapper;
import com.heaboy.service.stage.service.IStageService;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Service
public class StageServiceImpl extends ServiceImpl<StageMapper, Stage> implements IStageService {

    @Override
    public IPage<Stage> index(Page<Stage> page ,Stage stage){

        QueryWrapper<Stage> queryWrapper = new QueryWrapper<Stage>();
        if(!ObjectUtils.isEmpty(stage.getStageId())) {
            queryWrapper = queryWrapper.like("stageId",stage.getStageId());
        }
        if(!ObjectUtils.isEmpty(stage.getStageName())) {
            queryWrapper = queryWrapper.like("stageName",stage.getStageName());
        }
        if(!ObjectUtils.isEmpty(stage.getStatus())) {
            queryWrapper = queryWrapper.like("status",stage.getStatus());
        }
        IPage<Stage> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }
}
