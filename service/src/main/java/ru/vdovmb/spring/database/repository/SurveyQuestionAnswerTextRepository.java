package ru.vdovmb.spring.database.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.SurveyQuestionAnswerText;

@Repository
public class SurveyQuestionAnswerTextRepository extends RepositoryBase<Integer, SurveyQuestionAnswerText> {

    public SurveyQuestionAnswerTextRepository(EntityManager entityManager) {
        super(SurveyQuestionAnswerText.class, entityManager);
    }
}
