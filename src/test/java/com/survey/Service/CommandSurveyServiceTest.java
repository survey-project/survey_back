package com.survey.Service;

import com.survey.DTO.SurveyQuestionDto;
import com.survey.DTO.SurveyRequestInfoDto;
import com.survey.Entity.SurveyQuestionEntity;
import com.survey.Repository.Command.CommandSurveyQuestionRepository;
import com.survey.Repository.Command.CommandSurveyRepository;
import com.survey.Repository.Query.QuerySurveyQuestionRepository;
import com.survey.Service.inter.CommandSurveyService;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CommandSurveyServiceTest {

    @Autowired
    QuerySurveyQuestionRepository surveyQuestionRepository;

    @Autowired
    CommandSurveyRepository commandSurveyRepository;

    @Autowired
    CommandSurveyQuestionRepository commandSurveyQuestionRepository;

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

    @Test
    void CommandSurveyServiceTest() throws Exception {
        Optional<SurveyQuestionEntity> question = surveyQuestionRepository.findById(1L);
        assertThat(question).isPresent();

        // Entity의 값 확인 1
        SurveyQuestionEntity savedQuestion1 = question.get();
        assertThat(savedQuestion1.getSurveyContent()).isEqualTo("질문 1 내용");
        assertThat(savedQuestion1.getSurveyType()).isEqualTo(1);
        AssertionsForInterfaceTypes.assertThat(savedQuestion1.getChoices()).containsExactly("선택지 1", "선택지 2", "선택지 3");

        Optional<SurveyQuestionEntity> question2 = surveyQuestionRepository.findById(2L);
        assertThat(question2).isPresent();

        // Entity의 값 확인 2
        SurveyQuestionEntity savedQuestion2 = question2.get();
        assertThat(savedQuestion2.getSurveyContent()).isEqualTo("질문 2 내용");
        assertThat(savedQuestion2.getSurveyType()).isEqualTo(2);

        // 주관식 질문이므로 choices 필드는 null 또는 비어야 함
        AssertionsForInterfaceTypes.assertThat(savedQuestion2.getChoices()).isNull(); // 또는 .isEmpty()를 사용
    }
}
