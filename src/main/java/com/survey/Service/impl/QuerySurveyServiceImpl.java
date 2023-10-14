package com.survey.Service.impl;

import com.survey.DTO.SurveyDto;
import com.survey.Entity.SurveyEntity;
import com.survey.Global.Exception.ClientException;
import com.survey.Global.Exception.ErrorCode;
import com.survey.Repository.Query.QuerySurveyRepository;
import com.survey.Service.inter.QuerySurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class QuerySurveyServiceImpl implements QuerySurveyService {
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
    public SurveyDto getSurveyInfoBySurveyId(Long Id) {
        SurveyEntity survey = querySurveyRepository.findById(Id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "SurveyId : " + Id
                ));

        return SurveyDto.fromEntity(survey);
    }
}
