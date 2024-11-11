package ru.vdovmb.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vdovmb.spring.entity.Survey;
import ru.vdovmb.spring.repository.SurveyQuestionRepository;
import ru.vdovmb.spring.repository.SurveyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final SurveyQuestionRepository surveyQuestionRepository;


    // Создание нового опроса
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    // Получение опроса по ID
    public Optional<Survey> findById(Integer id) {
        return surveyRepository.findById(id);
    }

    // Получение всех опросов
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Удаление опроса по ID
    public void deleteSurvey(Survey survey) {
        surveyRepository.delete(survey);
    }
}
