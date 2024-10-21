package ru.vdovmb.spring.database.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.Question;

@Repository
public class QuestionRepository extends RepositoryBase<Integer, Question> {

    public QuestionRepository(EntityManager entityManager) {
        super(Question.class, entityManager);
    }
}
