package com.survey.Entity.User;

import com.survey.Entity.Admin.SurveyEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserSurveyQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surveyId")
    private Long surveyId;

    @Column(name = "surveyContent")
    private String surveyContent;

    @Column(name = "response")
    @ElementCollection
    private List<String> response;

    /**
     * 설문조사 테이블과 N:1
     */
    @ManyToOne
    @JoinColumn(name = "userSurvey_id") // SURVEY_ID 컬럼을 생성
    private UserSurveyEntity userSurvey;
}
