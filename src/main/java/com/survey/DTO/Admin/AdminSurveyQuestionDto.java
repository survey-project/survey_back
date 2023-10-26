package com.survey.DTO.Admin;

import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.Admin.SurveyQuestionEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 설문조사 질문들에 대한 선택지를 입력받는 Dto 입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AdminSurveyQuestionDto {
    /**
     * 질문 내용
     */
    @NotBlank
    private String surveyContent;

    /**
     * 질문 유형 (객관식, 주관식 선택)
     * 1. 단일 선택
     * 2. 다중 선택
     * 3. 단답형
     * 4. 장문형
     */
    @NotNull
    private String surveyType;

    /**
     * 객관식 질문의 선택지 목록
     */
    @NotEmpty
    private List<String> choices;


    public SurveyQuestionEntity toEntity(SurveyEntity survey) {
        return SurveyQuestionEntity.builder()
                .surveyContent(getSurveyContent())
                .surveyType(getSurveyType())
                .choices(getChoices())
                .survey(survey)
                .build();
    }

    public SurveyQuestionEntity toEntity(){
        return SurveyQuestionEntity.builder()
                .surveyContent(getSurveyContent())
                .surveyType(getSurveyType())
                .choices(getChoices())
                .build();
    }

    public static AdminSurveyQuestionDto fromEntity(SurveyQuestionEntity surveyQuestionEntity) {
        return new AdminSurveyQuestionDto(
                surveyQuestionEntity.getSurveyContent(),
                surveyQuestionEntity.getSurveyType(),
                surveyQuestionEntity.getChoices()
        );
    }
}
