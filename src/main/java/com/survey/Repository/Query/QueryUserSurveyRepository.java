package com.survey.Repository.Query;

import com.survey.Entity.User.UserSurveyEntity;

import java.util.Optional;

public interface QueryUserSurveyRepository {
    /**
     * SurveyEntity의 Id를 찾는 기능입니다.
     * @param id
     * @return Optional<SurveyEnitty>
     * @author ghkdtlwns987
     * @since  1.0
     */
    Optional<UserSurveyEntity> findById(Long id);
}
