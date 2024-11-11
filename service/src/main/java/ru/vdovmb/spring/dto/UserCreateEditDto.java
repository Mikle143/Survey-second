package ru.vdovmb.spring.dto;
import lombok.Value;
import ru.vdovmb.spring.entity.Role;

@Value
public class UserCreateEditDto {
    String name;
    String login;
    Role role;
}
