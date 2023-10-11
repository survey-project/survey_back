package com.survey.Repository.Query;

import com.survey.Entity.SurveyQuestionEntity;

import java.util.Optional;

/**
 * SurveyQuestion Entity관련 쿼리를 실행하는 레파지토리입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
public interface QuerySurveyQuestionRepository {
    /**
     * SurveyQuestionEntity 의 Id를 찾는 메서드입니다.
     * @param id
     * @return
     */
    Optional<SurveyQuestionEntity> findById(Long id);
}
