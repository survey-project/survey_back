package com.survey.Service.User.Impl;

import com.survey.Entity.Admin.SurveyQuestionEntity;
import com.survey.Entity.User.UserSurveyQuestionEntity;
import com.survey.Global.Exception.ClientException;
import com.survey.Global.Exception.ErrorCode;
import com.survey.Repository.Command.UserCommandSurveyQuestionRepository;
import com.survey.Service.User.Inter.UserQuerySurveyQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserQuerySurveyQuestionSerivceImpl implements UserQuerySurveyQuestionService {
    private final UserCommandSurveyQuestionRepository userCommandSurveyQuestionRepository;
    @Override
    @Transactional(readOnly = true)
    public UserSurveyQuestionEntity findUserSurveyQuestionById(Long id) {
        return userCommandSurveyQuestionRepository.findById(id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_NOT_EXIST,
                        "UserSurveyQuestion Id: " + id
                ));
    }
}
