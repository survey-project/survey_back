package com.survey.Controller.User;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.User.UserSurveyQuestionDto;
import com.survey.DTO.User.UserSurveyRequestInfoDto;
import com.survey.DTO.UserSurveyDto;
import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Global.Dto.ResultCode;
import com.survey.Global.Dto.ResultResponse;
import com.survey.Service.User.Inter.UserCommandSurveyService;
import com.survey.Service.User.Inter.UserQuerySurveyService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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
    private final UserQuerySurveyService userQuerySurveyService;
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

    /**
     * 사용자가 응답한 설문조사 결과를 가져옵니다.
     * 설문조사 Id (surveyId) 를 기존으로 불러오게 됩니다.
     * @param surveyId
     * @author 황시준
     * @since  1.0
     */
    @GetMapping("/submit/{surveyId}")
    public EntityModel<ResultResponse> submitResult(@PathVariable Long surveyId){
        UserSurveyDto userSurveyDto = userQuerySurveyService.getUserSurveyResultBySurveyId(surveyId);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.GET_SURVEY_REQUEST_SUCCESS, userSurveyDto);

        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(UserSurveyController.class).withSelfRel());

        return entityModel;
    }
}
