package com.survey.Service.impl;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.Entity.SurveyEntity;
import com.survey.Entity.SurveyQuestionEntity;
import com.survey.Repository.Command.CommandSurveyQuestionRepository;
import com.survey.Repository.Command.CommandSurveyRepository;
import com.survey.Service.inter.CommandSurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandSurveyServiceImpl implements CommandSurveyService{
    private final CommandSurveyRepository commandSurveyRepository;
    private final CommandSurveyQuestionRepository commandSurveyQuestionRepository;

    /**
     *
     * @param surveyRequestInfoDto
     * @return
     * @throws Exception
     */
    @Transactional
    @Override
    public SurveyDto createSurvey(SurveyRequestInfoDto surveyRequestInfoDto) throws Exception {
        // 설문조사한 사람은 설문하지 못하도록 로직 추가(예정)

        SurveyEntity surveyEntity = surveyRequestInfoDto.toEntity();

        // 설문 질문들을 Stream을 사용하여 변환하여 저장
        List<SurveyQuestionEntity> questionEntities = getQuestionEntities(surveyRequestInfoDto, surveyEntity);
        surveyEntity.setSurveyAnswer(questionEntities);

        commandSurveyRepository.save(surveyEntity);
        commandSurveyQuestionRepository.saveAll(questionEntities);

        // 설문 정보를 저장 후 SurveyDto 반환
        return SurveyDto.fromEntity(surveyEntity);
    }

    @Override
    public SurveyDto getSurveyResult(Long Id) throws Exception {
        return null;
    }


    /**
     * SurveyQuestionEntity를 List 형태로 반환하는 메서드 입니다.
     * @param surveyRequestInfoDto
     * @param survey
     * @return List<SurveyQuestionEntity>
     * @author 황시준
     * @since  1.0
     */

    public List<SurveyQuestionEntity> getQuestionEntities(SurveyRequestInfoDto surveyRequestInfoDto, SurveyEntity survey){
        return surveyRequestInfoDto.getSurveyAnswer()
                .stream()
                .map(surveyQuestionDto -> {
                    SurveyQuestionEntity questionEntity = surveyQuestionDto.toEntity(survey);
                    return questionEntity;
                })
                .collect(Collectors.toList());
    }
}
