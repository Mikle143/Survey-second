package ru.vdovmb.spring.database.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.Answer;

@Repository
public class AnswerRepository extends RepositoryBase<Integer, Answer> {

    public AnswerRepository(EntityManager entityManager) {
        super(Answer.class, entityManager);
    }
}
