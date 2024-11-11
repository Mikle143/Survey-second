package ru.vdovmb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vdovmb.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
