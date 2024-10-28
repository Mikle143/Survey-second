package ru.vdovmb.spring.database.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vdovmb.spring.database.entity.Survey;
import ru.vdovmb.spring.database.repository.SurveyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

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

    // Обновление опроса
    public Survey updateSurvey(Survey survey) {
        surveyRepository.update(survey);
        return survey;
    }

    // Удаление опроса по ID
    public void deleteSurvey(Integer id) {
        surveyRepository.delete(id);
    }
}
