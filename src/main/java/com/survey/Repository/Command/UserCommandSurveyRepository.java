package com.survey.Repository.Command;

import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.User.UserSurveyEntity;

public interface UserCommandSurveyRepository {
    /**
     * 설문조사 요청을 전달합니다..
     * @param survey
     * @return SurveyEntity
     * @author 황시준
     * @since  1.0
     */
    UserSurveyEntity save(UserSurveyEntity survey);
}
