package ru.vdovmb.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "answer")
public class Answer implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "survey_question_answer_text_id", nullable = false)
    private SurveyQuestionAnswerText surveyQuestionAnswerText;

    public void setUser(User user) {
        this.user = user;
        user.getAnswers().add(this);
    }

    public void setSurveyQuestionAnswerText(SurveyQuestionAnswerText surveyQuestionAnswerText) {
        this.surveyQuestionAnswerText = surveyQuestionAnswerText;
        surveyQuestionAnswerText.getAnswers().add(this);
    }
}
