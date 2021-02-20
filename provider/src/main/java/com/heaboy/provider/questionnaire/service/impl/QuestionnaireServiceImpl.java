package com.heaboy.provider.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.questionnaire.entity.Questionnaire;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.questionnaire.mapper.QuestionnaireMapper;
import com.heaboy.service.questionnaire.service.IQuestionnaireService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
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
public class QuestionnaireServiceImpl extends ServiceImpl<QuestionnaireMapper, Questionnaire> implements IQuestionnaireService {


    @Autowired
    QuestionnaireMapper questionnaireMapper;

    @Override
    public IPage<Questionnaire> index(Page<Questionnaire> page ,Questionnaire questionnaire){

        QueryWrapper<Questionnaire> queryWrapper = new QueryWrapper<Questionnaire>();
        if(!ObjectUtils.isEmpty(questionnaire.getQuestionarieId())) {
            queryWrapper = queryWrapper.like("questionarieId",questionnaire.getQuestionarieId());
        }
        if(!ObjectUtils.isEmpty(questionnaire.getQuestionarieTitle())) {
            queryWrapper = queryWrapper.like("questionarieTitle",questionnaire.getQuestionarieTitle());
        }
        if(!ObjectUtils.isEmpty(questionnaire.getStartTime())) {
            queryWrapper = queryWrapper.like("startTime",questionnaire.getStartTime());
        }
        if(!ObjectUtils.isEmpty(questionnaire.getEndTime())) {
            queryWrapper = queryWrapper.like("endTime",questionnaire.getEndTime());
        }
        if(!ObjectUtils.isEmpty(questionnaire.getCreatorId())) {
            queryWrapper = queryWrapper.like("creatorId",questionnaire.getCreatorId());
        }
        IPage<Questionnaire> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public int AddQuestionnaire(Questionnaire questionnaire) {
        int result = questionnaireMapper.insert(questionnaire);
        return result;
    }

    @Override
    public int updateByid(Questionnaire questionnaire) {
        return questionnaireMapper.updateByid(questionnaire);}
    @Override
    public Questionnaire selectQuestionnaireById(Long questionnaireId) {
        return questionnaireMapper.selectQuestionnaireById(questionnaireId);
    }
}
