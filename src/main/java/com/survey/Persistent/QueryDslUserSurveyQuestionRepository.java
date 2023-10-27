package com.survey.Persistent;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.survey.Entity.User.QUserSurveyEntity;
import com.survey.Entity.User.QUserSurveyQuestionEntity;
import com.survey.Entity.User.UserSurveyQuestionEntity;
import com.survey.Repository.Query.QueryUserSurveyQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QueryDslUserSurveyQuestionRepository implements QueryUserSurveyQuestionRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Optional<UserSurveyQuestionEntity> findById(Long id) {
        QUserSurveyQuestionEntity qUserSurveyEntity = QUserSurveyQuestionEntity.userSurveyQuestionEntity;
        return Optional.ofNullable(jpaQueryFactory.selectFrom(qUserSurveyEntity)
                .where(qUserSurveyEntity.id.eq(id))
                .fetchFirst());
    }
}
