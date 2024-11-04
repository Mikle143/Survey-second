package ru.vdovmb.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.database.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {


}
