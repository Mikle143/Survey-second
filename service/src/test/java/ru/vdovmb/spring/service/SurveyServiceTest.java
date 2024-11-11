package ru.vdovmb.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import ru.vdovmb.spring.SurveyService;
import ru.vdovmb.spring.dto.SurveyReadDto;
import ru.vdovmb.spring.entity.Survey;
import ru.vdovmb.spring.repository.SurveyRepository;
import ru.vdovmb.spring.listener.EntityEvent;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SurveyServiceTest {

    private static final Integer SURVEY_ID = 4;

    @Mock
    private SurveyRepository surveyRepository;

    @Mock
    private Survey survey;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private SurveyService surveyService;

    @Test
    void createSurvey() {
    }

    @Test
    void findById() {
        // Мокаем репозиторий, чтобы вернуть объект Survey с заданным ID
        Mockito.doReturn(Optional.of(new Survey(SURVEY_ID)))
                .when(surveyRepository).findById(SURVEY_ID);

        // Получаем результат из сервиса
        var surveyOptional = surveyService.findById(SURVEY_ID);
        var actualResult = surveyOptional.map(survey -> new SurveyReadDto(survey.getId()));


        // Проверка на наличие объекта
        assertTrue(surveyOptional.isPresent());

        // Ожидаемый результат
        var expectedResult = new SurveyReadDto(SURVEY_ID);

        // Сравнение фактического результата с ожидаемым
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

        // Проверяем, что событие было опубликовано
        verify(eventPublisher).publishEvent(any(EntityEvent.class));
    }

    @Test
    void getAllSurveys() {
    }

    @Test
    void updateSurvey() {
    }

    @Test
    void deleteSurvey() {
    }
}