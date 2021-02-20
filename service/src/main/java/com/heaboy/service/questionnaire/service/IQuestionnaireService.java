package com.heaboy.service.questionnaire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heaboy.service.questionnaire.entity.Questionnaire;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
  * $!{table.comment} 服务类
  * </p>
 *
 * @author heaboy
 * @since 2021-02-01
 */
public interface IQuestionnaireService extends IService<Questionnaire> {

    /**
    *
    * @param page
    * @param questionnaire
    * @return
    */
    IPage<Questionnaire> index(Page<Questionnaire> page ,Questionnaire questionnaire);


    int AddQuestionnaire(Questionnaire questionnaire);

    int updateByid(Questionnaire questionnaire);

    /**
     * 通过id查找问卷的实体类对象
     * @param questionnaireId
     * @return
     */
    Questionnaire selectQuestionnaireById(Long questionnaireId);

}
