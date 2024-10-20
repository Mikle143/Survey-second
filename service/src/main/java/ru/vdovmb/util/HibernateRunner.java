package ru.vdovmb.util;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.vdovmb.dao.UserRepository;

import java.lang.reflect.Proxy;
import java.sql.SQLException;

@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.bildSessionFactory()) {
            var session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                    (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));
            session.beginTransaction();

            var userRepository = new UserRepository(session);
            userRepository.findById(1).ifPresent(System.out::println);
            session.getTransaction().commit();
        }
    }
}