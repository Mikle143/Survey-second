package ru.vdovmb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.entity.SurveyQuestionAnswerText;

public interface SurveyQuestionAnswerTextRepository extends JpaRepository<SurveyQuestionAnswerText, Integer> {

}
