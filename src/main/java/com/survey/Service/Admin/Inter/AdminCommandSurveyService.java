package com.survey.Service.Admin.Inter;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.Admin.AdminSurveyRequestInfoDto;

public interface AdminCommandSurveyService {
    /**
     * 설문조사 결과를 저장하는 기능입니다.
     * @param adminSurveyRequestInfoDto
     * @return SurveyResponseInfoDto
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    SurveyDto createSurvey(AdminSurveyRequestInfoDto adminSurveyRequestInfoDto) throws Exception;

    /**
     * 설문조사를 삭제하는 기능입니다.
     * @param surveyDto
     * @return void
     * @author 황시준
     * @since  1.0
     */
    void deleteSurvey(SurveyDto surveyDto) throws Exception;
}
