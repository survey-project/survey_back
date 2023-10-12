package com.survey.DTO;

import com.survey.Entity.SurveyEntity;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 설문 정보를 입력받을 때 사용하는 DTO입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyRequestInfoDto {
    /**
     * 설문 제목
     */
    @NotBlank
    private String surveyTitle;

    /**
     * 설문 등록자
     */
    @NotBlank
    private String surveyRegistrants;

    /**
     * 설문 대상자
     */
    @NotBlank
    private String surveySubjects;

    /**
     * 설문 마감일
     */
    @NotNull
    private Date surveyDeadline;

    /**
     * 설문지 소개(설명)
     */
    @NotBlank
    private String surveyDescription;

    /**
     * 질문 내용
     */
    @NotEmpty
    private List<SurveyQuestionDto> surveyAnswer;

    public SurveyEntity toEntity(){
        return SurveyEntity.builder()
                .surveyTitle(getSurveyTitle())
                .surveyRegistrants(getSurveyRegistrants())
                .surveySubjects(getSurveySubjects())
                .surveyDeadline(new Date())
                .surveyDescription(getSurveyDescription())
                .build();
    }
}
