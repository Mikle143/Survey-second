package ru.vdovmb.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {


}
