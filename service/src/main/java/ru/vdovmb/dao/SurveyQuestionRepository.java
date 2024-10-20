package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import ru.vdovmb.entity.SurveyQuestion;


public class SurveyQuestionRepository extends RepositoryBase<Integer, SurveyQuestion> {

    public SurveyQuestionRepository(EntityManager entityManager) {
        super(SurveyQuestion.class, entityManager);
    }
}
