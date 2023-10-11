package com.survey.Persistent;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.survey.Entity.QSurveyQuestionEntity;
import com.survey.Entity.SurveyQuestionEntity;
import com.survey.Repository.Query.QuerySurveyQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class QueryDslSurveyQuestionRepository implements QuerySurveyQuestionRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<SurveyQuestionEntity> findById(Long id){
        QSurveyQuestionEntity qSurveyQuestionEntity = QSurveyQuestionEntity.surveyQuestionEntity;
        return Optional.ofNullable(jpaQueryFactory.selectFrom(qSurveyQuestionEntity)
                .where(qSurveyQuestionEntity.id.eq(id))
                .fetchFirst());

    }
}
