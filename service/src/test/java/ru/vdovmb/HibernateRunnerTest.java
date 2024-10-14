package ru.vdovmb;

import com.querydsl.jpa.impl.JPAQuery;
import org.assertj.core.api.Assertions;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.Test;
import ru.vdovmb.entity.QSurvey;
import ru.vdovmb.entity.Role;
import ru.vdovmb.entity.Survey;
import ru.vdovmb.entity.User;
import ru.vdovmb.util.HibernateTestUtil;

import java.util.List;

class HibernateRunnerTest {

    @Test
    void hqlFindSurveyByName() {
        try {
            var sessionFactory = HibernateTestUtil.buildSessionFactory();
            var session = sessionFactory.openSession();
            session.beginTransaction();
            String name = "Test";
            var list = session.createQuery("select s from Survey s where s.name =:SurveyName", Survey.class)
                    .setParameter("SurveyName", name)
                    .list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Test
    void UserSave() {
        try {
            var sessionFactory = HibernateTestUtil.buildSessionFactory();
            var session = sessionFactory.openSession();
            session.beginTransaction();

            var user = User.builder()
                    .name("Test")
                    .login("test")
                    .password("test")
                    .role(Role.GUEST)
                    .build();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void checkQuerydsl() {
        try {
            var sessionFactory = HibernateTestUtil.buildSessionFactory();
            var session = sessionFactory.openSession();
            session.beginTransaction();

            session.persist(Survey.builder()
                    .name("1a")
                    .build());
            session.persist(Survey.builder()
                    .name("2a")
                    .build());
            session.persist(Survey.builder()
                    .name("3a")
                    .build());
            // session.getTransaction().commit();

            List<Survey> surveys = new JPAQuery<Survey>(session)
                    .select(QSurvey.survey)
                    .from(QSurvey.survey)
                    .where(QSurvey.survey.name.like("%a%"))
                    .fetch();

            Assertions.assertThat(surveys).hasSize(3);
            Assertions.assertThat(surveys.stream().map(Survey::getName)).contains("1a", "2a", "3a");

            session.getTransaction().rollback();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}




