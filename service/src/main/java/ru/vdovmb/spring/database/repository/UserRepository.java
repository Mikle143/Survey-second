package ru.vdovmb.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.database.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
