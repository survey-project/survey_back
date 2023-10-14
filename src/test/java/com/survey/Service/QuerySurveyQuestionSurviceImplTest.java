package com.survey.Service;

import com.survey.DTO.SurveyQuestionDto;
import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.Service.inter.QuerySurveyQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;

@SpringBootTest
public class QuerySurveyQuestionSurviceImplTest {
    @Autowired
    QuerySurveyQuestionService querySurveyQuestionService;

    SurveyRequestInfoDto surveyRequestInfoDto;

    @BeforeEach
    void setUp(){
        surveyRequestInfoDto = new SurveyRequestInfoDto(
                "설문 제목 테스트",
                "설문 등록자 테스트",
                "설문 대상자 테스트",
                new Date(),
                "설문지 소개(설명1) 테스트",
                null
        );

        SurveyQuestionDto question1 = new SurveyQuestionDto(
                "질문 1 내용",
                1,
                Arrays.asList("선택지 1", "선택지 2", "선택지 3")
        );

        SurveyQuestionDto question2 = new SurveyQuestionDto(
                "질문 2 내용",
                2,
                Arrays.asList("선택지 1", "선택지 2", "선택지 3")
        );
        surveyRequestInfoDto.setSurveyAnswer(Arrays.asList(question1, question2));
    }
}
