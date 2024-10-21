package ru.vdovmb;

import org.assertj.core.api.Assertions;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.vdovmb.spring.database.entity.Role;
import ru.vdovmb.spring.database.entity.User;
import ru.vdovmb.util.HibernateTestUtil;

public class UserCrudTest {

    private static SessionFactory sessionFactory;

    @BeforeAll
    static void init() {
        sessionFactory = HibernateTestUtil.buildSessionFactory();
    }

    @AfterAll
    static void close() {
        sessionFactory.close();
    }

    @Test
    void UserCreate() {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var user = User.builder()
                    .name("Test")
                    .login("test")
                    .password("test")
                    .role(Role.GUEST)
                    .build();
            session.persist(user);

            Assertions.assertThat(session.get(User.class, user.getId())).isNotNull();
            Assertions.assertThat(session.get(User.class, user.getId()).getName()).isEqualTo("Test");
            Assertions.assertThat(session.get(User.class, user.getId()).getLogin()).isEqualTo("test");
            Assertions.assertThat(session.get(User.class, user.getId()).getPassword()).isEqualTo("test");
            session.getTransaction().rollback();
        }
    }

    @Test
    void UserRead() {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var user = User.builder()
                    .name("Test")
                    .login("test")
                    .password("test")
                    .role(Role.GUEST)
                    .build();
            session.persist(user);

            User userRead = session.get(User.class, user.getId());
            Assertions.assertThat(session.get(User.class, userRead.getId())).isNotNull();
            Assertions.assertThat(session.get(User.class, userRead.getId()).getName()).isEqualTo("Test");
            Assertions.assertThat(session.get(User.class, userRead.getId()).getLogin()).isEqualTo("test");
            Assertions.assertThat(session.get(User.class, userRead.getId()).getPassword()).isEqualTo("test");
            session.getTransaction().rollback();
        }
    }

    @Test
    void UserUpdate() {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var user = User.builder()
                    .name("Test")
                    .login("test")
                    .password("test")
                    .role(Role.GUEST)
                    .build();
            session.persist(user);

            user.setName("Update");
            user.setLogin("Update");
            user.setPassword("Update");
            session.persist(user);

            Assertions.assertThat(session.get(User.class, user.getId()).getName()).isEqualTo("Update");
            Assertions.assertThat(session.get(User.class, user.getId()).getLogin()).isEqualTo("Update");
            Assertions.assertThat(session.get(User.class, user.getId()).getPassword()).isEqualTo("Update");
            session.getTransaction().rollback();
        }
    }

    @Test
    void UserDelete() {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var user = User.builder()
                    .name("Test")
                    .login("test")
                    .password("test")
                    .role(Role.GUEST)
                    .build();
            session.persist(user);
            session.remove(user);

            Assertions.assertThat(session.get(User.class, user.getId())).isNull();
            session.getTransaction().rollback();
        }
    }
}
