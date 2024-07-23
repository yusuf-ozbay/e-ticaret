package org.example.eticaret.controller.mapper;

import org.example.eticaret.dto.UserDto;
import org.example.eticaret.request.UserRequest;
import org.example.eticaret.response.UserResponse;

public class UserControllerMapper {
    public static UserDto toDto(UserRequest userRequest) {
        return UserDto.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())

                .build();


    }

    public static UserResponse toResponse(UserDto userDto) {
       return UserResponse.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();

    }
}
