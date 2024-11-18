package ru.vdovmb.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.database.entity.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Integer> {

}
