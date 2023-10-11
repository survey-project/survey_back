package com.survey.Repository.Jpa;

import com.survey.Entity.SurveyEntity;
import com.survey.Repository.Command.CommandSurveyRepository;
import org.springframework.data.repository.Repository;

public interface JpaSurveyRepository extends Repository<SurveyEntity, Long>, CommandSurveyRepository {
}
