package com.survey.Entity.User;

import com.survey.Entity.Admin.SurveyEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class UserSurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private SurveyEntity survey;

    @OneToMany(mappedBy = "userSurvey", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserSurveyQuestionEntity> questionResponses;
}
