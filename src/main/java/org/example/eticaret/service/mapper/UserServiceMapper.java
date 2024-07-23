package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.UserDto;
import org.example.eticaret.entity.User;

public class UserServiceMapper {


    public static User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }

    public static UserDto toDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())

                .build();

    }
}
