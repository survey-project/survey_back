package com.survey.Service.inter;

import com.survey.Entity.SurveyEntity;
import com.survey.Entity.SurveyQuestionEntity;

public interface QuerySurveyService {
    /**
     * Id를 기반으로 SurveyEntity를 찾는 메서드 입니다.
     * @param id
     * @return
     */
    SurveyEntity findSurveyById(Long id);
}
