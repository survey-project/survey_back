package com.survey.Service.impl;

import com.survey.Entity.SurveyEntity;
import com.survey.Global.Exception.ClientException;
import com.survey.Global.Exception.ErrorCode;
import com.survey.Repository.Query.QuerySurveyRepository;
import com.survey.Service.inter.QuerySurveyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class QuerySurveyServiceImpl implements QuerySurveyService {
    private final QuerySurveyRepository querySurveyRepository;

    @Override
    public SurveyEntity findSurveyById(Long id) {
        return querySurveyRepository.findById(id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "SurveyId : " + id
                ));
    }
}
