package com.survey.Service.Admin.Impl;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.Admin.AdminSurveyRequestInfoDto;
import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.Admin.SurveyQuestionEntity;
import com.survey.Repository.Command.CommandSurveyQuestionRepository;
import com.survey.Repository.Command.CommandSurveyRepository;
import com.survey.Service.Admin.Inter.AdminCommandSurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminCommandSurveyServiceImpl implements AdminCommandSurveyService {
    private final CommandSurveyRepository commandSurveyRepository;
    private final CommandSurveyQuestionRepository commandSurveyQuestionRepository;
    @Transactional
    @Override
    public SurveyDto createSurvey(AdminSurveyRequestInfoDto adminSurveyRequestInfoDto) throws Exception {
        SurveyEntity surveyEntity = adminSurveyRequestInfoDto.toEntity();

        // 설문 질문들을 Stream을 사용하여 변환하여 저장
        List<SurveyQuestionEntity> questionEntities = getQuestionEntities(adminSurveyRequestInfoDto, surveyEntity);
        surveyEntity.setSurveyAnswer(questionEntities);

        commandSurveyRepository.save(surveyEntity);
        commandSurveyQuestionRepository.saveAll(questionEntities);

        // 설문 정보를 저장 후 SurveyDto 반환
        return SurveyDto.fromEntity(surveyEntity);
    }

    @Override
    public void deleteSurvey(SurveyDto surveyDto) throws Exception {
        commandSurveyRepository.deleteById(surveyDto.getId());
    }

    /**
     * SurveyQuestionEntity를 List 형태로 반환하는 메서드 입니다.
     * @param adminSurveyRequestInfoDto
     * @param survey
     * @return List<SurveyQuestionEntity>
     * @author 황시준
     * @since  1.0
     */
    public List<SurveyQuestionEntity> getQuestionEntities(AdminSurveyRequestInfoDto adminSurveyRequestInfoDto, SurveyEntity survey){
        return adminSurveyRequestInfoDto.getSurveyAnswer()
                .stream()
                .map(surveyQuestionDto -> {
                    SurveyQuestionEntity questionEntity = surveyQuestionDto.toEntity(survey);
                    return questionEntity;
                })
                .collect(Collectors.toList());
    }
}
