package com.survey.Service.inter;

import com.survey.Entity.SurveyQuestionEntity;

public interface QuerySurveyQuestionService {
    /**
     * SurveyQuestion Entity 를 찾는 메서드 입니다.
     * @param id
     * @return SurveyQuestionEntity
     * @author 황시준
     * @since  1.0
     */
    SurveyQuestionEntity findSurveyQuestionById(Long id);
}
