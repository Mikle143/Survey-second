package ru.vdovmb.dao;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.vdovmb.dto.AnswerFilter;
import ru.vdovmb.entity.Answer;
import ru.vdovmb.entity.User;
import ru.vdovmb.util.HibernateTestUtil;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;


class AnswerRepositoryTest {

    private static final SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory();
    private final AnswerFilterDao answerFilterDao = AnswerFilterDao.getInstance();

    @BeforeAll
    public static void initDb() {
        TestDataImporter.importData(sessionFactory);
    }

    @AfterAll
    public static void finish() {
        sessionFactory.close();
    }

    @Test
    void findAll() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Answer> results = answerFilterDao.findAll(session);
        assertThat(results).hasSize(5);

        List<User> users = results.stream().map(Answer::getUser).collect(toList());
        assertThat(users).extracting(User::getName).contains("name1");

        session.getTransaction().commit();
    }

    @Test
    void findAnswerFilter() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();

        AnswerFilter filter = AnswerFilter.builder()
                .surveyName("Survey1")
                .questionText("1Question")
             //   .answerText("aText1")
                .build();

        List<Answer> results = answerFilterDao.findAnswer(session, filter);
        assertThat(results).hasSize(2);


        session.getTransaction().commit();
    }
}
