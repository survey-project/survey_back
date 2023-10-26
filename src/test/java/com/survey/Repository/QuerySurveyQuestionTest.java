package com.survey.Repository;

import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.Admin.SurveyQuestionEntity;
import com.survey.Repository.Command.CommandSurveyQuestionRepository;
import com.survey.Repository.Command.CommandSurveyRepository;
import com.survey.Repository.Query.QuerySurveyQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Transactional
public class QuerySurveyQuestionTest {

    @Autowired
    private QuerySurveyQuestionRepository surveyQuestionRepository;

    @Autowired
    private CommandSurveyRepository commandSurveyRepository;

    @Autowired
    private CommandSurveyQuestionRepository commandSurveyQuestionRepository;

    @BeforeEach
    void setUp() {
        SurveyEntity survey = SurveyEntity.builder()
                .surveyTitle("설문 제목 테스트")
                .surveyRegistrants("설문 등록자 테스트")
                .surveySubjects("설문 대상자 테스트")
                .surveyDeadline(new Date())
                .surveyDescription("설문지 소개(설명) 테스트")
                .build();

        SurveyEntity savedSurvey = commandSurveyRepository.save(survey);

        SurveyQuestionEntity question1 = SurveyQuestionEntity.builder()
                .surveyContent("질문 1 내용")
                .surveyType(String.valueOf(1))
                .choices(Arrays.asList("선택지 1", "선택지 2", "선택지 3"))
                .survey(savedSurvey)
                .build();

        SurveyQuestionEntity question2 = SurveyQuestionEntity.builder()
                .surveyContent("질문 2 내용")
                .surveyType(String.valueOf(2))
                .survey(savedSurvey)
                .build();

        commandSurveyQuestionRepository.saveAll(Arrays.asList(question1, question2));
        }

    @Test
    void testSurveyQuestionQuery() {
        Optional<SurveyQuestionEntity> question = surveyQuestionRepository.findById(1L);
        assertThat(question).isPresent();

        // Entity의 값 확인 1
        SurveyQuestionEntity savedQuestion1 = question.get();
        assertThat(savedQuestion1.getSurveyContent()).isEqualTo("질문 1 내용");
        assertThat(savedQuestion1.getSurveyType()).isEqualTo(1);
        assertThat(savedQuestion1.getChoices()).containsExactly("선택지 1", "선택지 2", "선택지 3");

        Optional<SurveyQuestionEntity> question2 = surveyQuestionRepository.findById(2L);
        assertThat(question2).isPresent();

        // Entity의 값 확인 2
        SurveyQuestionEntity savedQuestion2 = question2.get();
        assertThat(savedQuestion2.getSurveyContent()).isEqualTo("질문 2 내용");
        assertThat(savedQuestion2.getSurveyType()).isEqualTo(2);

        // 주관식 질문이므로 choices 필드는 null 또는 비어야 함
        assertThat(savedQuestion2.getChoices()).isNull(); // 또는 .isEmpty()를 사용
    }
}