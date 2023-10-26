package com.survey.Entity.Admin;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 설문에 대한 질문을 정의하는 Entity 입니다.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SurveyQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 질문 내용
     */
    @Column
    private String surveyContent;

    /**
     * 질문 유형 (객관식, 주관식 선택)
     * 1. 단일 선택
     * 2. 다중 선택
     * 3. 단답형
     * 4. 장문형
     */
    @Column
    private String surveyType;

    /**
     * 객관식 질문의 선택지 목록
     */
    //@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<SurveyQuestionChoiceEntity> choices = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "question_choices", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "choice")
    private List<String> choices;


    /**
     * 설문조사 테이블과 N:1
     */
    @ManyToOne
    @JoinColumn(name = "survey_id") // SURVEY_ID 컬럼을 생성
    private SurveyEntity survey;


    public SurveyQuestionEntity toEntity(SurveyEntity survey){
        return SurveyQuestionEntity.builder()
                .surveyContent(getSurveyContent())
                .surveyType(getSurveyType())
                .choices(getChoices())
                .survey(survey)
                .build();
    }
}
