package ru.vdovmb;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import ru.vdovmb.entity.Role;
import ru.vdovmb.entity.Survey;
import ru.vdovmb.entity.User;
import ru.vdovmb.util.HibernateTestUtil;

import java.util.List;

class HibernateRunnerTest {

    @Test
    void HqlFindSurveyByName(){
        try{
            var sessionFactory = HibernateTestUtil.bildSessionFactory();
            var session = sessionFactory.openSession();
            session.beginTransaction();
            String name="Test";
            var list = session.createQuery("select s from Survey s where s.name =:SurveyName", Survey.class)
                    .setParameter("SurveyName",name)
                    .list();
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Test
    void UserSave() {
        try {
            var sessionFactory = HibernateTestUtil.bildSessionFactory();
            var session = sessionFactory.openSession();
            session.beginTransaction();

            var user = User.builder()
                    .name("Test")
                    .login("test")
                    .password("test")
                    .role(Role.GUEST.toString())
                    .build();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

}

