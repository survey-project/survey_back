package com.survey.Service.Admin.Impl;

import com.survey.DTO.SurveyDto;
import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Global.Exception.ClientException;
import com.survey.Global.Exception.ErrorCode;
import com.survey.Repository.Query.QuerySurveyRepository;
import com.survey.Service.Admin.Inter.AdminQuerySurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AdminQuerySurveyServiceImpl implements AdminQuerySurveyService {
    private final QuerySurveyRepository querySurveyRepository;

    @Override
    @Transactional(readOnly = true)
    public SurveyEntity findSurveyById(Long id) {
        return querySurveyRepository.findById(id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "SurveyId : " + id
                ));
    }

    @Override
    @Transactional(readOnly = true)
    public SurveyDto getSurveyResultBySurveyId(Long Id) {
        SurveyEntity survey = querySurveyRepository.findById(Id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "SurveyId : " + Id
                ));

        return SurveyDto.fromEntity(survey);
    }

    @Override
    public SurveyDto getSurveyResultBySurveyName(String surveyName) {
        SurveyEntity survey = querySurveyRepository.findSurveyBySurveyName(surveyName)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "SurveyName : " + surveyName
                        ));
        return SurveyDto.fromEntity(survey);
    }
}
