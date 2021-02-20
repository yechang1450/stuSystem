package com.heaboy.provider.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heaboy.service.questionnaire.entity.QuestionnaireOption;
import com.baomidou.mybatisplus.extension.service.IService;
import com.heaboy.provider.questionnaire.mapper.QuestionnaireOptionMapper;
import com.heaboy.service.questionnaire.service.IQuestionnaireOptionService;
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
public class QuestionnaireOptionServiceImpl extends ServiceImpl<QuestionnaireOptionMapper, QuestionnaireOption> implements IQuestionnaireOptionService {


    @Autowired
    QuestionnaireOptionMapper questionnaireOptionMapper;

    @Override
    public IPage<QuestionnaireOption> index(Page<QuestionnaireOption> page ,QuestionnaireOption questionnaireOption){

        QueryWrapper<QuestionnaireOption> queryWrapper = new QueryWrapper<QuestionnaireOption>();
        if(!ObjectUtils.isEmpty(questionnaireOption.getOptionId())) {
            queryWrapper = queryWrapper.like("optionId",questionnaireOption.getOptionId());
        }
        if(!ObjectUtils.isEmpty(questionnaireOption.getQuestionId())) {
            queryWrapper = queryWrapper.like("questionId",questionnaireOption.getQuestionId());
        }
        if(!ObjectUtils.isEmpty(questionnaireOption.getQuestionnaireId())) {
            queryWrapper = queryWrapper.like("questionnaireId",questionnaireOption.getQuestionnaireId());
        }
        if(!ObjectUtils.isEmpty(questionnaireOption.getOptionContent())) {
            queryWrapper = queryWrapper.like("optionContent",questionnaireOption.getOptionContent());
        }
        IPage<QuestionnaireOption> pageInfo = page(page,queryWrapper);
        return pageInfo;
    }

    @Override
    public int insert(List<QuestionnaireOption> questionnaireOptions) {
        return questionnaireOptionMapper.insert(questionnaireOptions);
    }

    @Override
    public List<QuestionnaireOption> selectOptions(Long questionnaireId, Long questionId) {
        return questionnaireOptionMapper.selectOptions(questionnaireId,questionId);
    }

    @Override
    public boolean deleteQuestionOption(QuestionnaireOption questionnaireOption) {
        int i = questionnaireOptionMapper.deleteQuestionOption(questionnaireOption);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean InsertQuestionOption(QuestionnaireOption questionnaireOption) {
        int i = questionnaireOptionMapper.InsertQuestionOption(questionnaireOption);
        if (i > 0){
            return true;
        }
        return false;
    }

}
