package com.survey.DTO;

import com.survey.Entity.SurveyQuestionEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 설문조사 질문들에 대한 Request 요청을 받는 Dto 입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SurveyQuestionDto {
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
    @NotBlank
    private int surveyType;

    /**
     * 객관식 질문의 선택지 목록
     */
    private List<String> choices;

    public List<SurveyQuestionEntity> toEntity(){
        return (List<SurveyQuestionEntity>) SurveyQuestionEntity.builder()
                .surveyContent(getSurveyContent())
                .surveyType(getSurveyType())
                .choices(getChoices())
                .build();
    }
}
