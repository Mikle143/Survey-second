package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.AnswerText;

public class AnswerTextRepositiry extends RepositiryBase<Integer, AnswerText> {

    public AnswerTextRepositiry(EntityManager entityManager) {
        super(AnswerText.class, entityManager);
    }
}
