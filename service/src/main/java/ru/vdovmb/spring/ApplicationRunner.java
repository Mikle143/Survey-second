package ru.vdovmb.spring;

import ru.vdovmb.spring.config.ApplicationConfiguration;
import ru.vdovmb.spring.database.entity.Survey;
import ru.vdovmb.spring.database.pool.ConnectionPool;
import ru.vdovmb.spring.database.repository.CrudRepository;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vdovmb.spring.database.repository.SurveyRepository;

import java.io.Serializable;

public class ApplicationRunner {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.getBean(SurveyRepository.class);
        SurveyRepository surveyRepository = context.getBean(SurveyRepository.class);
        surveyRepository.save(new Survey());

    }
}
