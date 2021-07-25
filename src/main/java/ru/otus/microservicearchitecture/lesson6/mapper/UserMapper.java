package ru.otus.microservicearchitecture.lesson6.mapper;

import ru.otus.microservicearchitecture.lesson6.entity.UserEntity;
import ru.otus.microservicearchitecture.lesson6.rest.model.User;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());

        return entity;
    }

    public static User toDto(UserEntity entity) {
        if (entity == null) return null;
        User user = new User();
        user.setId(entity.getId());
        user.setUsername(entity.getUsername());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setEmail(entity.getEmail());
        user.setPhone(entity.getPhone());

        return user;
    }

}
