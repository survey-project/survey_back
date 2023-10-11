package com.survey.Repository.Command;

import com.survey.Entity.SurveyQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandSurveyQuestionRepository extends JpaRepository<SurveyQuestionEntity, Long> {

}
