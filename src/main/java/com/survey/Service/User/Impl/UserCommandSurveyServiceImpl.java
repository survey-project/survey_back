package com.survey.Service.User.Impl;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.User.UserSurveyRequestInfoDto;
import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.User.UserSurveyEntity;
import com.survey.Entity.User.UserSurveyQuestionEntity;
import com.survey.Repository.Command.UserCommandSurveyQuestionRepository;
import com.survey.Repository.Command.UserCommandSurveyRepository;
import com.survey.Service.Admin.Inter.AdminQuerySurveyService;
import com.survey.Service.User.Inter.UserCommandSurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCommandSurveyServiceImpl implements UserCommandSurveyService {
    private final UserCommandSurveyRepository userCommandSurveyRepository;
    private final UserCommandSurveyQuestionRepository userCommandSurveyQuestionRepository;
    private final AdminQuerySurveyService adminQuerySurveyService;
    /**
     * 생성한 설문조사에 응답을 하는 메서드입니다.
     * @param userSurveyRequestInfoDto
     * @return SurveyDto
     * @throws Exception
     */
    @Override
    public SurveyDto submitSurvey(Long surveyId, UserSurveyRequestInfoDto userSurveyRequestInfoDto) throws Exception {
        SurveyEntity survey = adminQuerySurveyService.findSurveyById(surveyId);
        UserSurveyEntity userSurvey = userSurveyRequestInfoDto.toEntity(survey);

        List<UserSurveyQuestionEntity> surveyResposneEntities = getSurveyResponseEntities(userSurveyRequestInfoDto, userSurvey);
        userSurvey.setQuestionResponses(surveyResposneEntities);

        userCommandSurveyRepository.save(userSurvey);
        userCommandSurveyQuestionRepository.saveAll(surveyResposneEntities);

        return SurveyDto.fromEntity(survey);
    }

    @Override
    public SurveyDto getSurveyResult(Long surveyId) throws Exception {
        SurveyEntity survey = adminQuerySurveyService.findSurveyById(surveyId);
        return SurveyDto.fromEntity(survey);
    }

    /**
     * UserSurveyQuestionEntity 를 List 형태로 반환하는 메서드 입니다.
     * @param userSurveyRequestInfoDto
     * @param userSurveyEntity
     * @return List<UserSurveyQuestionEntity>
     * @author 황시준
     * @since  1.0
     */
    public List<UserSurveyQuestionEntity> getSurveyResponseEntities(UserSurveyRequestInfoDto userSurveyRequestInfoDto, UserSurveyEntity userSurveyEntity){
        return userSurveyRequestInfoDto.getSurveyResponse()
                .stream()
                .map(userSurveyQuestionDto -> {
                    UserSurveyQuestionEntity questionEntity = userSurveyQuestionDto.toEntity(userSurveyEntity);
                    return questionEntity;
                })
                .collect(Collectors.toList());
    }
}
