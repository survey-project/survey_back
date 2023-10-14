package com.survey.Service.inter;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.Entity.SurveyEntity;

public interface CommandSurveyService {
    /**
     * 설문조사 결과를 저장하는 기능입니다.
     * @param surveyRequestInfoDto
     * @return SurveyResponseInfoDto
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    SurveyDto createSurvey(SurveyRequestInfoDto surveyRequestInfoDto) throws Exception;

    /**
     * 설문조사 결과를 가져오는 기능입니다.
     * @param Id
     * @return SurveyDto
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    SurveyDto getSurveyResult(Long Id) throws Exception;
}
