package org.yusuf.eticaret.controller.mapper;

import org.yusuf.eticaret.dto.UserDto;
import org.yusuf.eticaret.request.UserRequest;
import org.yusuf.eticaret.response.UserResponse;

public class UserMapper {


    public static UserResponse toResponse(UserDto user){
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        return userResponse;
    }
    public static UserDto toDto (UserRequest userRequest){
        UserDto userDto=new UserDto();
        userDto.setName(userRequest.getName());
        userDto.setSurname(userRequest.getSurname());
        return userDto;
    }
}
