package com.survey.Repository.Query;

import com.survey.Entity.SurveyEntity;

import java.util.Optional;

public interface QuerySurveyRepository {
    /**
     * SurveyEntity의 Id를 찾는 기능입니다.
     * @param id
     * @return Optional<SurveyEnitty>
     * @author ghkdtlwns987
     * @since  1.0
     */
    Optional<SurveyEntity> findById(Long id);
}
