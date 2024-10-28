package ru.vdovmb.spring.database.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.SurveyQuestion;

@Repository
public class SurveyQuestionRepository extends RepositoryBase<Integer, SurveyQuestion> {

    public SurveyQuestionRepository(EntityManager entityManager) {
        super(SurveyQuestion.class, entityManager);
    }
}
