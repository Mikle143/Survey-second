package ru.vdovmb.spring.database.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.AnswerText;

@Repository
public class AnswerTextRepository extends RepositoryBase<Integer, AnswerText> {

    public AnswerTextRepository(EntityManager entityManager) {
        super(AnswerText.class, entityManager);
    }
}
