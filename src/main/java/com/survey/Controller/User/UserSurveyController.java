package com.survey.Controller.User;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.User.UserSurveyQuestionDto;
import com.survey.DTO.User.UserSurveyRequestInfoDto;
import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Global.Dto.ResultCode;
import com.survey.Global.Dto.ResultResponse;
import com.survey.Service.User.Inter.UserCommandSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * User가 사용하는 설문조사 Controller입니다.
 * Admin이 생성한 설문에 응답하기 위한 Controller 입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@RequestMapping("/v1/api/user/survey")
@RestController
@RequiredArgsConstructor
public class UserSurveyController {
    private final UserCommandSurveyService userCommandSurveyService;

    /**
     * 설문조사를 제출하는 메서드입니다.
     * 사용자가 제출합니다.
     * @author ghkdtlwns987
     * @since  1.0
     */
    @PostMapping("/submit/{surveyId}")
    public EntityModel<ResultResponse> submit(@PathVariable Long surveyId, @RequestBody @Valid UserSurveyRequestInfoDto userSurveyRequestInfoDto) throws Exception {
        SurveyDto surveyDto = userCommandSurveyService.submitSurvey(surveyId, userSurveyRequestInfoDto);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.SUBMIT_SURVEY_REQUEST_SUCCESS, surveyDto);
        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(UserSurveyController.class).withSelfRel());
        return entityModel;
    }
}
