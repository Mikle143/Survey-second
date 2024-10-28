package ru.vdovmb.spring.database.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.Survey;

@Repository
public class SurveyRepository extends RepositoryBase<Integer, Survey> {

    public SurveyRepository(EntityManager entityManager) {
        super(Survey.class, entityManager);
    }

}
