package ru.vdovmb.spring.database.repository;

import ru.vdovmb.spring.database.entity.Role;
import ru.vdovmb.spring.database.entity.User;
import ru.vdovmb.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
