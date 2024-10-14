package ru.vdovmb.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.User;

public class UserRepositiry extends RepositiryBase<Integer, User> {

    public UserRepositiry(EntityManager entityManager) {
        super(User.class, entityManager);
    }
}
