package com.survey.Service.impl;

import com.survey.Entity.SurveyQuestionEntity;
import com.survey.Global.Exception.ClientException;
import com.survey.Global.Exception.ErrorCode;
import com.survey.Repository.Query.QuerySurveyQuestionRepository;
import com.survey.Service.inter.QuerySurveyQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class QuerySurveyQuestionServiceImpl implements QuerySurveyQuestionService {
    private final QuerySurveyQuestionRepository querySurveyQuestionRepository;


    /**
     * SurveyQuestion Entity를 찾는 메서드 입니다.
     * @param id
     * @return SurveyQuestionEntity
     * @author 황시준
     * @since  1.0
     */
    @Override
    public SurveyQuestionEntity findSyrveyQuestionById(Long id) {
        return querySurveyQuestionRepository.findById(id)
                .orElseThrow(() -> new ClientException(
                        ErrorCode.SURVEY_QUESTION_NOT_EXIST,
                        "SurveyQuestion Id: " + id
                ));
    }
}
