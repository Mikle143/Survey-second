package ru.vdovmb.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vdovmb.spring.dto.UserCreateEditDto;
import ru.vdovmb.spring.entity.User;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);

        return user;
    }

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(UserCreateEditDto object, User user) {
        user.setName(object.getName());
        user.setLogin(object.getLogin());
        user.setRole(object.getRole());
    }
}
