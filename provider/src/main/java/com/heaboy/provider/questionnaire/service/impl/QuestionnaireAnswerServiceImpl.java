package com.heaboy.provider.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.questionnaire.entity.QuestionnaireAnswer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.questionnaire.mapper.QuestionnaireAnswerMapper;
import com.heaboy.service.questionnaire.service.IQuestionnaireAnswerService;
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
public class QuestionnaireAnswerServiceImpl extends ServiceImpl<QuestionnaireAnswerMapper, QuestionnaireAnswer> implements IQuestionnaireAnswerService {

    @Autowired
    QuestionnaireAnswerMapper questionnaireAnswerMapper;

    @Override
    public IPage<QuestionnaireAnswer> index(Page<QuestionnaireAnswer> page ,QuestionnaireAnswer questionnaireAnswer){

        QueryWrapper<QuestionnaireAnswer> queryWrapper = new QueryWrapper<QuestionnaireAnswer>();
        if(!ObjectUtils.isEmpty(questionnaireAnswer.getUserId())) {
            queryWrapper = queryWrapper.like("userId",questionnaireAnswer.getUserId());
        }
        if(!ObjectUtils.isEmpty(questionnaireAnswer.getQuestionnaireId())) {
            queryWrapper = queryWrapper.like("questionnaireId",questionnaireAnswer.getQuestionnaireId());
        }
        if(!ObjectUtils.isEmpty(questionnaireAnswer.getQuestionId())) {
            queryWrapper = queryWrapper.like("questionId",questionnaireAnswer.getQuestionId());
        }
        if(!ObjectUtils.isEmpty(questionnaireAnswer.getAnswer())) {
            queryWrapper = queryWrapper.like("answer",questionnaireAnswer.getAnswer());
        }
        if(!ObjectUtils.isEmpty(questionnaireAnswer.getOperateTime())) {
            queryWrapper = queryWrapper.like("operateTime",questionnaireAnswer.getOperateTime());
        }
        IPage<QuestionnaireAnswer> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public boolean answerQuestionnaire(List<QuestionnaireAnswer> questionnaireAnswerList) {
        int i = questionnaireAnswerMapper.answerQuestionnaire(questionnaireAnswerList);
        if (i>0){
            return true;
        }
        return false;
    }
}
