package com.survey.DTO;

import com.survey.Entity.SurveyEntity;
import com.survey.Entity.SurveyQuestionEntity;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SurveyDto {
    /**
     * 설문 Id(Primary Key)
     */
    private Long id;
    /**
     * 설문 제목
     */
    private String surveyTitle;

    /**
     * 설문 등록자
     */
    private String surveyRegistrants;

    /**
     * 설문 대상자
     */
    private String surveySubjects;

    /**
     * 설문 마감일
     */
    private Date surveyDeadline;

    /**
     * 설문지 소개(설명)
     */
    private String surveyDescription;

    /**
     * 질문 내용
     */
    private List<SurveyQuestionDto> surveyQuestions;


    public static SurveyDto fromEntity(SurveyEntity survey) {
        List<SurveyQuestionDto> questionDto = survey.getSurveyAnswer().stream()
                .map(SurveyQuestionDto::fromEntity)
                .collect(Collectors.toList());

        SurveyDto surveyDtoBuilder = SurveyDto.builder()
                .id(survey.getId())
                .surveyTitle(survey.getSurveyTitle())
                .surveyRegistrants(survey.getSurveyRegistrants())
                .surveySubjects(survey.getSurveySubjects())
                .surveyDeadline(survey.getSurveyDeadline())
                .surveyDescription(survey.getSurveyDescription())
                .surveyQuestions(questionDto)
                .build();
        return surveyDtoBuilder;
    }

}
