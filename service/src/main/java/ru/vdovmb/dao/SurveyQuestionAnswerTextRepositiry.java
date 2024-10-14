package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.SurveyQuestionAnswerText;


public class SurveyQuestionAnswerTextRepositiry extends RepositiryBase<Integer, SurveyQuestionAnswerText> {

    public SurveyQuestionAnswerTextRepositiry(EntityManager entityManager) {
        super(SurveyQuestionAnswerText.class, entityManager);
    }
}
