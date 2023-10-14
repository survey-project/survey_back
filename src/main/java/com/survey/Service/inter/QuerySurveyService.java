package com.survey.Service.inter;

import com.survey.DTO.SurveyDto;
import com.survey.Entity.SurveyEntity;

public interface QuerySurveyService {
    /**
     * Id를 기반으로 SurveyEntity를 찾는 메서드 입니다.
     * @param id
     * @return SurveyEntity
     */
    SurveyEntity findSurveyById(Long id);

    /**
     * Id 를 기반으로 설문조사 결과를 가져옴
     * @param Id
     * @return SurveyDto
     */
    SurveyDto getSurveyInfoBySurveyId(Long Id);
}
