package ru.vdovmb.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "survey_question_answer_text")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SurveyQuestionAnswerText implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_text_id", nullable = false)
    private AnswerText answerText;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_question_id", nullable = false)
    private SurveyQuestion surveyQuestion;

    @OneToMany(mappedBy = "surveyQuestionAnswerText")
    private List<Answer> answers;

    public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
        this.surveyQuestion.getSurveyQuestionAnswerTexts().add(this);
    }

    public void setAnswerText(AnswerText answerText) {
        this.answerText = answerText;
        answerText.getSurveyQuestionAnswerTexts().add(this);
    }
}

