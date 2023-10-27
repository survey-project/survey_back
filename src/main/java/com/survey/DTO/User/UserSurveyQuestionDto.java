package com.survey.DTO.User;

import com.survey.DTO.Admin.AdminSurveyQuestionDto;
import com.survey.Entity.Admin.SurveyQuestionEntity;
import com.survey.Entity.User.UserSurveyEntity;
import com.survey.Entity.User.UserSurveyQuestionEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 설문조사 질문들에 대한 선택지를 받는 Dto 입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserSurveyQuestionDto {
    /**
     * 설문 문제 번호
     */
    @NotNull
    private Long questionId;

    /**
     * 설문 문제 질문 내용
     */
    @NotNull
    private String surveyContent;

    /**
     * 설문 응답
     */
    @NotEmpty
    private List<String> userChoices;

    public UserSurveyQuestionEntity toEntity(UserSurveyEntity userSurvey){
        return UserSurveyQuestionEntity.builder()
                .surveyContent(getSurveyContent())
                .surveyId(userSurvey.getSurvey().getId())
                .response(getUserChoices())
                .userSurvey(userSurvey)
                .build();
    }

    public UserSurveyQuestionEntity toEntity(Long surveyId){
        return UserSurveyQuestionEntity.builder()
                .surveyContent(getSurveyContent())
                .surveyId(surveyId)
                .response(getUserChoices())
                .build();
    }
    public static UserSurveyQuestionDto fromEntity(UserSurveyQuestionEntity userSurveyQuestionEntity) {
        return new UserSurveyQuestionDto(
                userSurveyQuestionEntity.getSurveyId(),
                userSurveyQuestionEntity.getSurveyContent(),
                userSurveyQuestionEntity.getResponse());
    }
}
