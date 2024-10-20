package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import ru.vdovmb.entity.Survey;

public class SurveyRepository extends RepositoryBase<Integer, Survey> {

    public SurveyRepository(EntityManager entityManager) {
        super(Survey.class, entityManager);
    }
}
