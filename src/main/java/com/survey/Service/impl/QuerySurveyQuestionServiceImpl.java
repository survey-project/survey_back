package com.survey.Service.impl;

import com.survey.Entity.SurveyQuestionEntity;
import com.survey.Repository.Query.QuerySurveyQuestionRepository;
import com.survey.Service.inter.QuerySurveyQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class QuerySurveyQuestionServiceImpl implements QuerySurveyQuestionService {
    private final QuerySurveyQuestionRepository querySurveyQuestionRepository;


    @Override
    public SurveyQuestionEntity findSyrveyQuestionById(Long id) {
        return null;
    }
}
