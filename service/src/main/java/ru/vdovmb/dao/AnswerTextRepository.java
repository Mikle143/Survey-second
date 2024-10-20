package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import ru.vdovmb.entity.AnswerText;

public class AnswerTextRepository extends RepositoryBase<Integer, AnswerText> {

    public AnswerTextRepository(EntityManager entityManager) {
        super(AnswerText.class, entityManager);
    }
}
