package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import ru.vdovmb.entity.SurveyQuestionAnswerText;


public class SurveyQuestionAnswerTextRepository extends RepositoryBase<Integer, SurveyQuestionAnswerText> {

    public SurveyQuestionAnswerTextRepository(EntityManager entityManager) {
        super(SurveyQuestionAnswerText.class, entityManager);
    }
}
