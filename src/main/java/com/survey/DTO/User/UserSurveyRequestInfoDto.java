package com.survey.DTO.User;

import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.User.UserSurveyEntity;
import com.survey.Entity.User.UserSurveyQuestionEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자가 생성한 설문에 응답 보내는 Dto 입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSurveyRequestInfoDto {
    /**
     * 설문 응답자
     */
    @NotBlank
    private String surveyRespondents;

    /**
     * 질문 내용
     */
    @NotNull
    @NotEmpty
    private List<UserSurveyQuestionDto> surveyResponse;

    public UserSurveyEntity toEntity(SurveyEntity survey){
        List<UserSurveyQuestionEntity> questionEntities = getUserSurveyQuestionEntities(survey.getId());
        return UserSurveyEntity.builder()
                .survey(survey)
                .questionResponses(questionEntities)
                .build();
    }

    public List<UserSurveyQuestionEntity> getUserSurveyQuestionEntities(Long surveyId){
        return surveyResponse.stream()
                .map(UserSurveyQuestionDto -> UserSurveyQuestionDto.toEntity(surveyId))
                .collect(Collectors.toList());
    }
}
