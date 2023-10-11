package com.survey.Service.inter;

import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.DTO.SurveyResponseInfoDto;

public interface CommandSurveyService {
    /**
     * 설문조사 결과를 저장하는 기능입니다.
     * @param surveyRequestInfoDto
     * @return SurveyResponseInfoDto
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    SurveyResponseInfoDto createSurvey(SurveyRequestInfoDto surveyRequestInfoDto) throws Exception;
}
