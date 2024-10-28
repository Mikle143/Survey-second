package ru.vdovmb.spring.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Survey implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    // Связь с сущностью "survey_question"
    @OneToMany(mappedBy = "survey")
    private List<SurveyQuestion> surveyQuestions;

    public Survey(Integer surveyId) {
        Survey survey = new Survey();
    }
}
