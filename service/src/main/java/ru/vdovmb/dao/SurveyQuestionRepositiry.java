package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.SurveyQuestion;


public class SurveyQuestionRepositiry extends RepositiryBase<Integer, SurveyQuestion> {

    public SurveyQuestionRepositiry(EntityManager entityManager) {
        super(SurveyQuestion.class, entityManager);
    }
}
