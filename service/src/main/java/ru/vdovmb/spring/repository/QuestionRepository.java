package ru.vdovmb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {


}
