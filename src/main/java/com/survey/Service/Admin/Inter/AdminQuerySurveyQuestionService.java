package com.survey.Service.Admin.Inter;

import com.survey.Entity.Admin.SurveyQuestionEntity;

public interface AdminQuerySurveyQuestionService {
    /**
     * SurveyQuestion Entity 를 찾는 메서드 입니다.
     * @param id
     * @return SurveyQuestionEntity
     * @author 황시준
     * @since  1.0
     */
    SurveyQuestionEntity findSurveyQuestionById(Long id);
}
