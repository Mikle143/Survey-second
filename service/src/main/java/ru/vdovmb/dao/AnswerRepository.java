package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import ru.vdovmb.entity.Answer;


public class AnswerRepository extends RepositoryBase<Integer, Answer> {

    public AnswerRepository(EntityManager entityManager) {
        super(Answer.class, entityManager);
    }
}
