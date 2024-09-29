package ru.vdovmb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import ru.vdovmb.entity.Answer;
import ru.vdovmb.entity.AnswerText;
import ru.vdovmb.entity.Question;
import ru.vdovmb.entity.Role;
import ru.vdovmb.entity.Survey;
import ru.vdovmb.entity.User;

class HibernateRunnerTest {
    @Test
    void testEntitiesCreate() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            Survey survey = Survey.builder()
                    .id(1)
                    .name("1")
                    .build();
            session.save(survey);

            Question question= Question.builder()
                    .questionText("www")
                    .answersNumber(2)
                    .id(1)
                    .build();
            session.save(question);

            AnswerText answerText = AnswerText.builder()
                    .answerText("ttt")
                    .id(1)
                    .build();
            session.save(answerText);

            User user= User.builder()
                    .name("Ivan")
                    .login("Ivan9")
                    .password("pass")
                    .role(Role.GUEST)
                    .build();
            session.save(user);

            Answer answer = Answer.builder()
                    .id(25)
                    .survey(survey)
                    .question(question)
                    .answerText(answerText)
                    .user(user)
                    .build();

            session.save(answer);

            session.getTransaction().commit();
        }
    }

}