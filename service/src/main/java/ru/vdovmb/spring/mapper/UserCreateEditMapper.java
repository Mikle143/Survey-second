package ru.vdovmb.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.hibernate.sql.model.jdbc.OptionalTableUpdateOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.vdovmb.spring.database.entity.User;
import ru.vdovmb.spring.dto.UserCreateEditDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);
        user.setPassword(object.getPassword());

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

        Optional.ofNullable(object.getImage())
                .filter(MultipartFile::isEmpty)
                .ifPresent(image->user.setImage(image.getOriginalFilename()));
    }
}
