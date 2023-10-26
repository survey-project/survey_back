package com.survey.Repository.Command;

import com.survey.Entity.User.UserSurveyQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommandSurveyQuestionRepository extends JpaRepository<UserSurveyQuestionEntity, Long> {
}
