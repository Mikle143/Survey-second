package ru.vdovmb.spring.dto;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;
import ru.vdovmb.spring.database.entity.Role;

@Value
public class UserCreateEditDto {
    String name;
    String login;
    Role role;
    String password;
    MultipartFile image;
}
