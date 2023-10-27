package com.survey.Controller.Admin;

import com.survey.DTO.SurveyDto;
import com.survey.DTO.Admin.AdminSurveyRequestInfoDto;
import com.survey.Global.Dto.ResultCode;
import com.survey.Global.Dto.ResultResponse;
import com.survey.Service.Admin.Inter.AdminCommandSurveyService;
import com.survey.Service.Admin.Inter.AdminQuerySurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * 설문조사 관련 Controller 입니다.
 * 해당 Controller는 Admin 과 같이 인증된 사용자가 생성하는 설문을 담당합니다.
 * @author ghkdtlwns987
 * @since  1.0
 */
@RestController
@RequestMapping("/v1/api/admin/survey")
@RequiredArgsConstructor
public class AdminSurveyController {
    private final AdminCommandSurveyService adminCommandSurveyService;
    private final AdminQuerySurveyService adminQuerySurveyService;

    /**
     * 설문을 제출하는 Controller 입니다.
     * @param adminSurveyRequestInfoDto
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    @PostMapping("/create")
    public EntityModel<ResultResponse> surveySubmit(@RequestBody @Valid AdminSurveyRequestInfoDto adminSurveyRequestInfoDto) throws Exception {
        SurveyDto surveyDto = adminCommandSurveyService.createSurvey(adminSurveyRequestInfoDto);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.CREATE_SURVEY_REQUEST_SUCCESS, surveyDto);
        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(AdminSurveyController.class).withSelfRel());

        return entityModel;
    }

    /**
     * 설문 결과를 조회하는 Controller 입니다.
     * @param surveyId
     * @throws Exception
     * @author 황시준
     * @since  1.0
     */
    @GetMapping("/result/{surveyId}")
    public EntityModel<ResultResponse> surveyResult(@PathVariable Long surveyId) throws Exception {
        SurveyDto surveyDto = adminQuerySurveyService.getSurveyResultBySurveyId(surveyId);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.GET_SURVEY_REQUEST_SUCCESS, surveyDto);

        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(AdminSurveyController.class).withSelfRel());

        return entityModel;
    }

    /**
     * 설문을 삭제하는 메서드 입니다.
     * @param surveyId
     * @throws Exception
     * @author 황시준
     * @sicne  1.0
     */
    @DeleteMapping("/delete/{surveyId}")
    public EntityModel<ResultResponse> deleteSurvey(@PathVariable Long surveyId) throws Exception{
        SurveyDto surveyDto = adminQuerySurveyService.getSurveyResultBySurveyId(surveyId);
        adminCommandSurveyService.deleteSurvey(surveyDto);
        ResultResponse resultResponse = ResultResponse.of(ResultCode.DELETE_SURVEY_REQUEST_SUCCESS, surveyDto.getSurveyTitle());

        EntityModel<ResultResponse> entityModel = EntityModel.of(resultResponse);
        entityModel.add(linkTo(AdminSurveyController.class).withSelfRel());

        return entityModel;
    }
}
