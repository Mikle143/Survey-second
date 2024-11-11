package ru.vdovmb.spring.dto;

import lombok.Value;
import ru.vdovmb.spring.entity.Role;

@Value
public class UserReadDto {
    Integer id;
    String name;
    String login;
    Role role;
}
