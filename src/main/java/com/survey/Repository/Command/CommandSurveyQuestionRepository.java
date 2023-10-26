package com.survey.Repository.Command;

import com.survey.Entity.Admin.SurveyQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommandSurveyQuestionRepository extends JpaRepository<SurveyQuestionEntity, Long> {

}
