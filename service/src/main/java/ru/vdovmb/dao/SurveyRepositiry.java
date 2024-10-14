package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.Survey;

public class SurveyRepositiry extends RepositiryBase<Integer, Survey> {

    public SurveyRepositiry(EntityManager entityManager) {
        super(Survey.class, entityManager);
    }
}
