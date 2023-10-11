package com.survey.Service.impl;

import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.DTO.SurveyResponseInfoDto;
import com.survey.Entity.SurveyQuestionEntity;
import com.survey.Repository.Command.CommandSurveyRepository;
import com.survey.Service.inter.CommandSurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandSurveyServiceImpl implements CommandSurveyService{
    private final CommandSurveyRepository commandSurveyRepository;
    @Override
    public SurveyResponseInfoDto createSurvey(SurveyRequestInfoDto surveyRequestInfoDto) throws Exception {
        /**
         * 설문조사한 사람은 설문하지 못하도록 로직 추가
         */
        //return commandSurveyRepository.save(surveyRequestInfoDto.toEntity());

        //SurveyQuestionEntity surveyQuestionEntity = surveyRequestInfoDto.toEntity();
        //commandSurveyRepository.save(surveyRequestInfoDto.toEntity());
        return null;
    }
}
