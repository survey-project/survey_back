package com.survey.Repository.Query;

import com.survey.Entity.User.UserSurveyQuestionEntity;

import java.util.Optional;

public interface QueryUserSurveyQuestionRepository {
    Optional<UserSurveyQuestionEntity> findById(Long id);
}
