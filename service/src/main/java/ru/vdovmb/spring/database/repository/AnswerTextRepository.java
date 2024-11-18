package ru.vdovmb.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.database.entity.AnswerText;

public interface AnswerTextRepository extends JpaRepository<AnswerText, Integer> {

}
