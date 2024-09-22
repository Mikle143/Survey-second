package ru.vdovmb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class AnswerEntity {

    @Id
    private Integer surveyId;
    private Integer questionTextId;
    private Integer answerTextId;
    private Integer userId;
}
