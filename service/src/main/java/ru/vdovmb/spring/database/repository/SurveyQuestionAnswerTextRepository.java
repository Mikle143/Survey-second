package ru.vdovmb.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.database.entity.SurveyQuestionAnswerText;

public interface SurveyQuestionAnswerTextRepository extends JpaRepository<SurveyQuestionAnswerText, Integer> {

}
