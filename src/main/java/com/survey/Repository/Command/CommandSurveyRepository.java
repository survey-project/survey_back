package com.survey.Repository.Command;

import com.survey.Entity.Admin.SurveyEntity;

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

    /**
     * 생성한 설문조사를 삭제합니다.
     * @param Id
     * @author 황시준
     * @sicne  1.0
     */
    String deleteById(Long Id);
}
