package ru.vdovmb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.entity.AnswerText;

public interface AnswerTextRepository extends JpaRepository<AnswerText, Integer> {

}
