package ru.vdovmb.entity;

import jakarta.persistence.Entity;
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
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Связь с пользователем
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Связь с опросом
    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    // Связь с вопросом
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // Связь с текстом ответа
    @ManyToOne
    @JoinColumn(name = "answer_text_id", nullable = false)
    private AnswerText answerText;
}
