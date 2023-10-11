package com.survey.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private int surveyType;

    /**
     * 객관식 질문의 선택지 목록
     */
    @ElementCollection
    @CollectionTable(name = "question_choices", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "choice")
    private List<String> choices;

    /**
     * 설문조사 테이블과 N:1
     */
    @ManyToOne
    private SurveyEntity survey;
}
