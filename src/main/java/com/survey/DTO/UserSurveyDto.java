package com.survey.DTO;

import com.survey.DTO.User.UserSurveyQuestionDto;
import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.User.UserSurveyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserSurveyDto {
    private Long questionId;

    private SurveyEntity survey;

    private List<UserSurveyQuestionDto> questionResponses;


    public static UserSurveyDto fromEntity(UserSurveyEntity userSurvey){
        List<UserSurveyQuestionDto> questionDto = userSurvey.getQuestionResponses().stream()
                .map(UserSurveyQuestionDto::fromEntity)
                .collect(Collectors.toList());

        UserSurveyDto userSurveyDto = UserSurveyDto.builder()
                .questionId(userSurvey.getId())
                .survey(userSurvey.getSurvey())
                .questionResponses(questionDto)
                .build();

        return userSurveyDto;
    }
}
