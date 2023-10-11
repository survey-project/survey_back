package com.survey.Service.inter;

import com.survey.Entity.SurveyQuestionEntity;

import java.util.Optional;

public interface QuerySurveyQuestionService {
    SurveyQuestionEntity findSyrveyQuestionById(Long id);
}
