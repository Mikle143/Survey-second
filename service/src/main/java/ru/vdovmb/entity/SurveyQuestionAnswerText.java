package ru.vdovmb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "survey_question_answer_text")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyQuestionAnswerText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "answer_text_id", nullable = false)
    private AnswerText answerText;

    @ManyToOne
    @JoinColumn(name = "survey_question_id", nullable = false)
    private SurveyQuestion surveyQuestion;
}

