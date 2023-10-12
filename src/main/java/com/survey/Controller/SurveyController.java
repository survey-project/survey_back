package com.survey.Controller;

import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.DTO.SurveyResponseInfoDto;
import com.survey.Service.inter.CommandSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @PostMapping("/submit")
    public SurveyResponseInfoDto submit(@RequestBody @Valid SurveyRequestInfoDto surveyRequestInfoDto) throws Exception {
        return surveyService.createSurvey(surveyRequestInfoDto);
    }

    @GetMapping("/result")
    public Survey
}
