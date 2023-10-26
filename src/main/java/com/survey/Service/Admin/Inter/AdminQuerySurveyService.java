package com.survey.Service.Admin.Inter;

import com.survey.DTO.SurveyDto;
import com.survey.Entity.Admin.SurveyEntity;

public interface AdminQuerySurveyService {
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
    SurveyDto getSurveyResultBySurveyId(Long Id);

    /**
     * 설문조사 이름을 기반으로 설문조사 결과를 가져옴.
     * @param surveyName
     * @return surveyDto
     */
    SurveyDto getSurveyResultBySurveyName(String surveyName);
}
