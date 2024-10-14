package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.Question;


public class QuestionRepositiry extends RepositiryBase<Integer, Question> {

    public QuestionRepositiry(EntityManager entityManager) {
        super(Question.class, entityManager);
    }
}
