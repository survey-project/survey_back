package com.survey.Entity.Admin;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 설문 제목
     */
    private String surveyTitle;

    /**
     * 설문 등록자
     */
    private String surveyRegistrants;

    /**
     * 설문 대상자
     */
    private String surveySubjects;

    /**
     * 설문 마감일
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date surveyDeadline;

    /**
     * 설문지 소개(설명)
     */
    private String surveyDescription;

    /**
     * 설문조사 질문 내용
     */
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SurveyQuestionEntity> surveyAnswer = new ArrayList<>();
}
