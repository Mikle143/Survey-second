package ru.vdovmb.spring.integration.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vdovmb.spring.ApplicationRunner;
import ru.vdovmb.spring.dto.SurveyReadDto;
import ru.vdovmb.spring.database.repository.SurveyRepository;
import ru.vdovmb.spring.service.SurveyService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ApplicationRunner.class)
public class SurveyServiceIT {

    private static final Integer SURVEY_ID = 4;

    @Autowired
    private SurveyService surveyService;
    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    void checkFindByName() {
        var survey1 = surveyRepository.findByNameWithQuestions("опрос_1");
        assertNotNull(survey1);
        survey1.ifPresent(survey -> assertEquals(4, survey.getId()));

    }

    @Test
    void findById() {
        // Получаем Survey по ID
        var surveyOptional = surveyService.findById(SURVEY_ID);

        // Проверяем, что результат найден
        assertTrue(surveyOptional.isPresent());

        // Преобразуем Survey в SurveyReadDto
        var actualResult = surveyOptional.map(survey -> new SurveyReadDto(survey.getId()));

        // Создаем ожидаемый объект SurveyReadDto с нужным ID
        var expectedResult = new SurveyReadDto(SURVEY_ID);

        // Сравниваем фактический и ожидаемый результаты SurveyReadDto
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}
