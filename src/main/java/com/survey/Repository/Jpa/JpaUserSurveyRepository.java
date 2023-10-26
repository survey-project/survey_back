package com.survey.Repository.Jpa;

import com.survey.Entity.User.UserSurveyEntity;
import com.survey.Repository.Command.UserCommandSurveyRepository;
import org.springframework.data.repository.Repository;

public interface JpaUserSurveyRepository extends Repository<UserSurveyEntity, Long>, UserCommandSurveyRepository {
}
