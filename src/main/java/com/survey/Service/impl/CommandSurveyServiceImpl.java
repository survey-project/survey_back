package com.survey.Service.impl;

import com.survey.DTO.SurveyQuestionDto;
import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.DTO.SurveyResponseInfoDto;
import com.survey.Entity.SurveyEntity;
import com.survey.Entity.SurveyQuestionEntity;
import com.survey.Repository.Command.CommandSurveyQuestionRepository;
import com.survey.Repository.Command.CommandSurveyRepository;
import com.survey.Service.inter.CommandSurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandSurveyServiceImpl implements CommandSurveyService{
    private final CommandSurveyRepository commandSurveyRepository;
    private final CommandSurveyQuestionRepository commandSurveyQuestionRepository;
    @Override
    public SurveyResponseInfoDto createSurvey(SurveyRequestInfoDto surveyRequestInfoDto) throws Exception {
        /**
         * 설문조사한 사람은 설문하지 못하도록 로직 추가
         */

        SurveyEntity surveyEntity = surveyRequestInfoDto.toEntity();
        // 설문 질문들을 SurveyQuestionEntity로 변환하여 저장
        List<SurveyQuestionEntity> questionEntities = new ArrayList<>();
        for (SurveyQuestionDto questionDto : surveyRequestInfoDto.getSurveyAnswer()) {
            SurveyQuestionEntity questionEntity = questionDto.toEntity();
            questionEntities.add(questionEntity);
        }

        // 질문들을 저장
        commandSurveyQuestionRepository.saveAll(questionEntities);

        // 설문 정보를 저장
        commandSurveyRepository.save(surveyEntity);
        //SurveyQuestionEntity surveyQuestionEntity = surveyRequestInfoDto.toEntity();
        //commandSurveyRepository.save(surveyRequestInfoDto.toEntity());
        return null;
    }
}
