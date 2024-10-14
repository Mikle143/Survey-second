package ru.vdovmb;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.vdovmb.dao.AnswerFilterDao;
import ru.vdovmb.dto.AnswerFilter;
import ru.vdovmb.entity.Answer;
import ru.vdovmb.entity.User;
import ru.vdovmb.util.HibernateTestUtil;
import ru.vdovmb.util.TestDataImporter;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.*;

@TestInstance(PER_CLASS)
class AnswerRepositiryTest {

    private final SessionFactory sessionFactory = HibernateTestUtil.buildSessionFactory();
    private final AnswerFilterDao answerDao = AnswerFilterDao.getInstance();

    @BeforeAll
    public void initDb() {
        TestDataImporter.importData(sessionFactory);
    }

    @AfterAll
    public void finish() {
        sessionFactory.close();
    }

    @Test
    void findAll() {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Answer> results = answerDao.findAll(session);
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
//                .answerText("aText1")
                .build();

        List<Answer> results = answerDao.findAnswer(session, filter);
        assertThat(results).hasSize(2);


        session.getTransaction().commit();
    }
}
