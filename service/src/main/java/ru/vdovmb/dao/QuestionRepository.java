package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import ru.vdovmb.entity.Question;


public class QuestionRepository extends RepositoryBase<Integer, Question> {

    public QuestionRepository(EntityManager entityManager) {
        super(Question.class, entityManager);
    }
}
