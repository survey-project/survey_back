package com.survey.Service.User.Inter;

import com.survey.DTO.UserSurveyDto;
import com.survey.Entity.User.UserSurveyEntity;

public interface UserQuerySurveyService {
    /**
     * Id를 기반으로 UserSurveyEntity 를 찾는 메서드 입니다.
     * @param id
     * @return SurveyEntity
     */
    UserSurveyEntity findSurveyById(Long id);

    /**
     * Id 를 기반으로 설문조사 결과를 가져옴
     * @param Id
     * @return SurveyDto
     */
    UserSurveyDto getUserSurveyResultBySurveyId(Long Id);
}
