package com.survey.Persistent;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.survey.Entity.Admin.QSurveyEntity;
import com.survey.Entity.User.QUserSurveyEntity;
import com.survey.Entity.User.UserSurveyEntity;
import com.survey.Repository.Query.QueryUserSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QueryDslUserSurveyRepository implements QueryUserSurveyRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Optional<UserSurveyEntity> findById(Long id) {
        QUserSurveyEntity survey = QUserSurveyEntity.userSurveyEntity;
        return Optional.ofNullable(jpaQueryFactory.selectFrom(survey)
                .where(survey.Id.eq(id))
                .fetchFirst());
    }
}
