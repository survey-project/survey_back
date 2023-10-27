package com.survey.Service.User.Inter;

import com.survey.Entity.User.UserSurveyQuestionEntity;

public interface UserQuerySurveyQuestionService {
    /**
     * 사용자가 설문조사 응답한 요소를 가져오는 메서드 입니다.
     * @param id
     * @return UserSurveyQuestionEntity
     * @author 황시준
     * @since  1.0
     */
    UserSurveyQuestionEntity findUserSurveyQuestionById(Long id);
}
