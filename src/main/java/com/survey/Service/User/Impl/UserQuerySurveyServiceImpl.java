package com.survey.Service.User.Impl;

import com.survey.DTO.UserSurveyDto;
import com.survey.Entity.User.UserSurveyEntity;
import com.survey.Global.Exception.ClientException;
import com.survey.Global.Exception.ErrorCode;
import com.survey.Repository.Query.QueryUserSurveyRepository;
import com.survey.Service.User.Inter.UserQuerySurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserQuerySurveyServiceImpl implements UserQuerySurveyService {
    private final QueryUserSurveyRepository queryUserSurveyRepository;
    @Override
    @Transactional(readOnly = true)
    public UserSurveyEntity findSurveyById(Long id) {
        return queryUserSurveyRepository.findById(id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "Survey Id : " + id
                ));
    }

    @Override
    @Transactional(readOnly = true)
    public UserSurveyDto getUserSurveyResultBySurveyId(Long Id) {
        UserSurveyEntity userSurvey = queryUserSurveyRepository.findById(Id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "SurveyIde : " + Id
                ));
        return UserSurveyDto.fromEntity(userSurvey);
    }
}
