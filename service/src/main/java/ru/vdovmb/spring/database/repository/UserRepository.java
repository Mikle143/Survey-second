package ru.vdovmb.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.Role;
import ru.vdovmb.spring.database.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>,
        FilterUserRepository,
        RevisionRepository<User, Integer, Integer>,
        QuerydslPredicateExecutor<User> {

    @Query("select u from User u " +
           "where u.name like %:name% and u.login like %:login%")

    List<User> findAllBy(String name, String login);

    @Query(value = "SELECT u.* FROM users u WHERE u.name = :name",
            nativeQuery = true)

    List<User> findAllByUsername(String name);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update User u " +
           "set u.role = :role " +
           "where u.id in (:ids)")
    int updateRole(Role role, Integer... ids);
}



