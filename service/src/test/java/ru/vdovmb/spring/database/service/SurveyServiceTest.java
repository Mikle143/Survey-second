package ru.vdovmb.spring.database.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import ru.vdovmb.spring.database.dto.SurveyReadDto;
import ru.vdovmb.spring.database.entity.Survey;
import ru.vdovmb.spring.database.repository.SurveyRepository;
import ru.vdovmb.spring.listener.EntityEvent;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
        Mockito.doReturn(Optional.of(new Survey(SURVEY_ID)))
                .when(surveyRepository).findById(SURVEY_ID);

        var actualResult = surveyService.findById(SURVEY_ID);

        assertTrue(actualResult.isPresent());
        assertEquals(SURVEY_ID, actualResult.get().getId());

        var expectedResult = new SurveyReadDto(SURVEY_ID);

        assertEquals(expectedResult, actualResult);

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