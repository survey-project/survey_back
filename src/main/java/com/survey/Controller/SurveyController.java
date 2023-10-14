package com.survey.Controller;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.Global.Dto.ResultCode;
import com.survey.Global.Dto.ResultResponse;
import com.survey.Service.inter.CommandSurveyService;
import com.survey.Service.inter.QuerySurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * 설문조사 관련 Controller 입니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@RestController
@RequestMapping("/v1/api/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final CommandSurveyService surveyService;
    private final QuerySurveyService querySurveyService;
    @PostMapping("/submit")
    public EntityModel<ResultResponse> submit(@RequestBody @Valid SurveyRequestInfoDto surveyRequestInfoDto) throws Exception {
        SurveyDto surveyDto = surveyService.createSurvey(surveyRequestInfoDto);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.CREATE_SURVEY_REQUEST_SUCCESS, surveyDto);
        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(SurveyController.class).withSelfRel());

        return entityModel;
    }

    @GetMapping("/result/{surveyId}")
    public EntityModel<ResultResponse> result(@PathVariable Long Id) throws Exception {
        SurveyDto surveyDto = querySurveyService.getSurveyInfoBySurveyId(Id);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.GET_SURVEY_REQUEST_SUCCESS, surveyDto);

        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(SurveyController.class).withSelfRel());

        return entityModel;
    }
}
