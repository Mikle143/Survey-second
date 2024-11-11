package ru.vdovmb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.entity.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Integer> {

}
