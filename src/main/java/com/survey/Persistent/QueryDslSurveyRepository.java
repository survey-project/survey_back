package com.survey.Persistent;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.survey.Entity.QSurveyEntity;
import com.survey.Entity.SurveyEntity;
import com.survey.Repository.Query.QuerySurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QueryDslSurveyRepository implements QuerySurveyRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Optional<SurveyEntity> findById(Long id){
        QSurveyEntity survey = QSurveyEntity.surveyEntity;
        return Optional.ofNullable(jpaQueryFactory.selectFrom(survey)
                .where(survey.id.eq(id))
                .fetchFirst());
    }
}
