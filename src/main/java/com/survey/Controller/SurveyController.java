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

    /**
     * 설문을 제출하는 Controller 입니다.
     * @param surveyRequestInfoDto
     * @return EntityModel<ResultResponse>
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    @PostMapping("/submit")
    public EntityModel<ResultResponse> surveySubmit(@RequestBody @Valid SurveyRequestInfoDto surveyRequestInfoDto) throws Exception {
        SurveyDto surveyDto = surveyService.createSurvey(surveyRequestInfoDto);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.CREATE_SURVEY_REQUEST_SUCCESS, surveyDto);
        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(SurveyController.class).withSelfRel());

        return entityModel;
    }

    /**
     * 설문 결과를 조회하는 Controller 입니다.
     * @param Id
     * @return EntityModel<ResultResponse>
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    @GetMapping("/result/{surveyId}")
    public EntityModel<ResultResponse> surveyResult(@PathVariable Long surveyId) throws Exception {
        SurveyDto surveyDto = querySurveyService.getSurveyResultBySurveyId(surveyId);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.GET_SURVEY_REQUEST_SUCCESS, surveyDto);

        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(SurveyController.class).withSelfRel());

        return entityModel;
    }
}
