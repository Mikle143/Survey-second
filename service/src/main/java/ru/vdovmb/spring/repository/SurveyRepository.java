package ru.vdovmb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vdovmb.spring.entity.Survey;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    @Query("SELECT s FROM Survey s LEFT JOIN FETCH s.surveyQuestions WHERE s.name = :name")
    Optional<Survey> findByNameWithQuestions(@Param("name") String name);

}
