package ru.vdovmb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import ru.vdovmb.entity.AnswerEntity;
import ru.vdovmb.entity.AnswerTextEntity;
import ru.vdovmb.entity.QuestionEntity;
import ru.vdovmb.entity.Role;
import ru.vdovmb.entity.SurveyEntity;
import ru.vdovmb.entity.SurveyQuestionAnswerEntity;
import ru.vdovmb.entity.SurveyQuestionEntity;
import ru.vdovmb.entity.UserEntity;

class HibernateRunnerTest {
    @Test
    void testEntitiesCreate() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            System.out.println("OK");
            session.beginTransaction();


            SurveyEntity survey = SurveyEntity.builder()
                    .id(1)
                    .name("1")
                    .build();
            session.save(survey);

            QuestionEntity question= QuestionEntity.builder()
                    .questionText("www")
                    .answersNumber(2)
                    .id(1)
                    .build();
            session.save(question);

            AnswerTextEntity answerText = AnswerTextEntity.builder()
                    .answerText("qqq")
                    .id(1)
                    .build();
            session.save(answerText);

            SurveyQuestionEntity surveyQuestion=SurveyQuestionEntity.builder()
                    .surveyId(1)
                    .questionId(1)
                    .build();
            session.save(surveyQuestion);

            SurveyQuestionAnswerEntity surveyQuestionAnswer=SurveyQuestionAnswerEntity.builder()
                    .surveyId(1)
                    .questionId(1)
                    .answerTextId(1)
                    .build();
            session.save(surveyQuestionAnswer);

            UserEntity user= UserEntity.builder()
                    .userId(1)
                    .name("Ivan")
                    .login("Ivan")
                    .password("pass")
                    .role(Role.GUEST)
                    .build();
            session.save(user);

            AnswerEntity answerEntity = AnswerEntity.builder()
                    .userId(1)
                    .questionTextId(1)
                    .answerTextId(1)
                    .surveyId(1)
                    .build();
            session.save(answerEntity);

            session.getTransaction().commit();
        }
    }

}