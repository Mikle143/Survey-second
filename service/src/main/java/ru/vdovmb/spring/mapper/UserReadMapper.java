package ru.vdovmb.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vdovmb.spring.dto.UserReadDto;
import ru.vdovmb.spring.entity.User;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User obj) {
        return new UserReadDto(
                obj.getId(),
                obj.getName(),
                obj.getLogin(),
                obj.getRole()
        );
    }
}
