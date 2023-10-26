package com.survey.Repository.Query;

import com.survey.Entity.Admin.SurveyEntity;

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

    /**
     * SurveyName으로 SurveyEntity를 검색하는 기능입니다.
     * @param name
     * @return Optional<SurveyEnitty>
     * @author ghkdtlwns987
     * @since  1.0
     */
    Optional<SurveyEntity> findSurveyBySurveyName(String name);
}
