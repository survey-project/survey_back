package com.survey.Service;
import com.survey.DTO.SurveyDto;
import com.survey.DTO.Admin.AdminSurveyQuestionDto;
import com.survey.DTO.Admin.AdminSurveyRequestInfoDto;
import com.survey.Entity.Admin.SurveyEntity;
import com.survey.Entity.Admin.SurveyQuestionEntity;
import com.survey.Repository.Command.CommandSurveyQuestionRepository;
import com.survey.Repository.Command.CommandSurveyRepository;
import com.survey.Service.Admin.Impl.AdminCommandSurveyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdminCommandSurveyServiceTest {

    SurveyEntity survey;
    SurveyDto surveyDto;
    SurveyQuestionEntity surveyQuestionEntity;
    AdminSurveyQuestionDto adminSurveyQuestionDto;

    AdminSurveyRequestInfoDto adminSurveyRequestInfoDto;
    private Long Id = 1L;
    private String surveyTitle = "설문 제목 테스트";
    private String surveyRegistrations = "설문 등록자 테스트";
    private String surveySubjects = "설문 대상자 테스트";
    private Date date = new Date();
    private String surveyDescription = "설문지 소개(설명1) 테스트";

    private String surveyContent = "질문 내용 테스트";
    private int surveyType = 1;
    private List<String> choices = Arrays.asList("선택지 1", "선택지 2", "선택지 3");
    @BeforeEach
    void setUp() {

        survey = SurveyEntity.builder()
                .id(Id)
                .surveyTitle(surveyTitle)
                .surveyRegistrants(surveyRegistrations)
                .surveySubjects(surveySubjects)
                .surveyDeadline(date)
                .surveyDescription(surveyDescription)
                .surveyAnswer(null)
                .build();

        List<SurveyQuestionEntity> questions = new ArrayList<>();
        questions.add(
                SurveyQuestionEntity.builder()
                        .surveyContent("질문 1 내용")
                        .surveyType(String.valueOf(1))
                        .choices(Arrays.asList("선택지 1", "선택지 2", "선택지 3"))
                        .survey(survey)
                        .build()
        );

        questions.add(
                SurveyQuestionEntity.builder()
                        .surveyContent("질문 2 내용")
                        .surveyType(String.valueOf(3))
                        .choices(Collections.emptyList())
                        .survey(survey)
                        .build()
        );

        questions.add(
                SurveyQuestionEntity.builder()
                        .surveyContent("질문 3 내용")
                        .surveyType(String.valueOf(2))
                        .choices(Collections.emptyList())
                        .survey(survey)
                        .build()
        );

        List<AdminSurveyQuestionDto> adminSurveyQuestionDto = new ArrayList<>();
        adminSurveyQuestionDto.add(
                AdminSurveyQuestionDto.builder()
                        .surveyContent("질문 1 내용")
                        .surveyType(String.valueOf(1))
                        .choices(Arrays.asList("선택지 1", "선택지 2", "선택지 3"))
                        .build()
        );

        adminSurveyQuestionDto.add(
                AdminSurveyQuestionDto.builder()
                        .surveyContent("질문 2 내용")
                        .surveyType(String.valueOf(3))
                        .choices(Collections.emptyList())
                        .build()
        );

        adminSurveyQuestionDto.add(
                AdminSurveyQuestionDto.builder()
                        .surveyContent("질문 3 내용")
                        .surveyType(String.valueOf(3))
                        .choices(Collections.emptyList())
                        .build()
        );

        surveyDto = SurveyDto.builder()
                .id(Id)
                .surveyTitle(surveyTitle)
                .surveyRegistrants(surveyRegistrations)
                .surveySubjects(surveySubjects)
                .surveyDeadline(date)
                .surveyDescription(surveyDescription)
                .surveyQuestions(adminSurveyQuestionDto)
                .build();

        adminSurveyRequestInfoDto = new AdminSurveyRequestInfoDto(
                "설문 제목 테스트",
                "설문 등록자 테스트",
                "설문 대상자 테스트",
                new Date(),
                "설문지 소개(설명1) 테스트",
                adminSurveyQuestionDto
        );

        survey.setSurveyAnswer(questions);
    }

    @Mock
    CommandSurveyRepository commandSurveyRepository;

    @Mock
    CommandSurveyQuestionRepository commandSurveyQuestionRepository;
    @InjectMocks
    AdminCommandSurveyServiceImpl commandSurveyService;
    @Test
    @DisplayName("Create Survey Test")
    public void createSurveyTest() throws Exception {
        SurveyDto result = commandSurveyService.createSurvey(adminSurveyRequestInfoDto);
        assertNotNull(result);
        assertEquals(result.getSurveyTitle(), surveyTitle);
        assertEquals(result.getSurveyRegistrants(), surveyRegistrations);
        assertEquals(result.getSurveySubjects(), surveySubjects);
        assertEquals(result.getSurveyDescription(), surveyDescription);

        List<AdminSurveyQuestionDto> testQuestions = result.getSurveyQuestions();
        List<AdminSurveyQuestionDto> originalQuestions = surveyDto.getSurveyQuestions();

        assertEquals(originalQuestions.size(), testQuestions.size());

        for (int i = 0; i < originalQuestions.size(); i++) {
            AdminSurveyQuestionDto originalQuestion = originalQuestions.get(i);
            AdminSurveyQuestionDto testQuestion = testQuestions.get(i);

            assertEquals(originalQuestion.getSurveyContent(), testQuestion.getSurveyContent());
            assertEquals(originalQuestion.getSurveyType(), testQuestion.getSurveyType());
            assertEquals(originalQuestion.getChoices(), testQuestion.getChoices());
        }
    }
}