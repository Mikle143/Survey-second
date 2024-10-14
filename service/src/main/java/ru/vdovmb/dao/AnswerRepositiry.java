package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.Answer;


public class AnswerRepositiry extends RepositiryBase<Integer, Answer> {

    public AnswerRepositiry(EntityManager entityManager) {
        super(Answer.class, entityManager);
    }
}
