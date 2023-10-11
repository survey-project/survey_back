package com.survey.Repository.Command;

import com.survey.Entity.SurveyEntity;

/**
 * 설문조사 등록 및 수정 관련 Repository
 * @author ghkdtlwns987
 * @since  1.0
 */
public interface CommandSurveyRepository {
    /**
     * 설문조사 데이터를 등록합니다.
     * @param survey
     * @return SurveyEntity
     * @author 황시준
     * @since  1.0
     */
    SurveyEntity save(SurveyEntity survey);
}
