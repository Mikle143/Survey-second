package ru.vdovmb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {


}
