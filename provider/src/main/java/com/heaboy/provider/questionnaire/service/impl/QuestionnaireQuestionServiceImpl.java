package com.heaboy.provider.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.provider.questionnaire.mapper.QuestionnaireOptionMapper;
import com.heaboy.service.questionnaire.entity.QuestionnaireOption;
import com.heaboy.service.questionnaire.entity.QuestionnaireQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.questionnaire.mapper.QuestionnaireQuestionMapper;
import com.heaboy.service.questionnaire.service.IQuestionnaireQuestionService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.apache.dubbo.config.annotation.Service;
import java.util.List;
import java.util.Map;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
@Service
public class QuestionnaireQuestionServiceImpl extends ServiceImpl<QuestionnaireQuestionMapper, QuestionnaireQuestion> implements IQuestionnaireQuestionService {

    @Autowired
    QuestionnaireQuestionMapper questionnaireQuestionMapper;

    @Autowired
    QuestionnaireOptionMapper questionnaireOptionMapper;

    @Override
    public IPage<QuestionnaireQuestion> index(Page<QuestionnaireQuestion> page ,QuestionnaireQuestion questionnaireQuestion){

        QueryWrapper<QuestionnaireQuestion> queryWrapper = new QueryWrapper<QuestionnaireQuestion>();
        if(!ObjectUtils.isEmpty(questionnaireQuestion.getQuestionId())) {
            queryWrapper = queryWrapper.like("questionId",questionnaireQuestion.getQuestionId());
        }
        if(!ObjectUtils.isEmpty(questionnaireQuestion.getQuestionTitle())) {
            queryWrapper = queryWrapper.like("questionTitle",questionnaireQuestion.getQuestionTitle());
        }
        if(!ObjectUtils.isEmpty(questionnaireQuestion.getQuestionType())) {
            queryWrapper = queryWrapper.like("questionType",questionnaireQuestion.getQuestionType());
        }
        if(!ObjectUtils.isEmpty(questionnaireQuestion.getQuestionaireId())) {
            queryWrapper = queryWrapper.like("questionaireId",questionnaireQuestion.getQuestionaireId());
        }
        IPage<QuestionnaireQuestion> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public Long insert(QuestionnaireQuestion questionnaireQuestion) {

        return questionnaireQuestionMapper.into(questionnaireQuestion);}
    @Override
    public boolean deleteQuestion(Long questionId, Long questionnaireId) {
        //删除该问题对应的全部选项
        int i = questionnaireOptionMapper.deleteOption(questionId, questionnaireId);
        //删除该问题
        int i1 = questionnaireQuestionMapper.deleteQuestion(questionId, questionnaireId);
        if (i1 == 0 || i1 < 0){
            return false;
        }
        return true;
    }

    @Override
    public List<QuestionnaireQuestion> selectQuestions(Long questionnaireId) {
        return questionnaireQuestionMapper.selectQuestions(questionnaireId);
    }

    @Override
    public boolean updateQuestion(QuestionnaireQuestion questionnaireQuestion) {
        int i = questionnaireQuestionMapper.updateQuestion(questionnaireQuestion);
        if (questionnaireQuestion.getQuestionType().equals("单选题") || questionnaireQuestion.getQuestionType().equals("多选题")){
            List<QuestionnaireOption> questionnaireOptionList = questionnaireQuestion.getQuestionnaireOptionList();
            for (QuestionnaireOption questionnaireOption : questionnaireOptionList){
                int i1 = questionnaireOptionMapper.updateQuestionOption(questionnaireOption);
            }
        }
        if (i > 0){
            return true;
        }else{
            return false;
        }

    }

}
