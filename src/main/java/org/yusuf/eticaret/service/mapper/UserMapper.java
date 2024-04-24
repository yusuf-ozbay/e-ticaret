package org.yusuf.eticaret.service.mapper;

import org.springframework.stereotype.Component;
import org.yusuf.eticaret.dto.UserDto;
import org.yusuf.eticaret.entity.User;
@Component
public class UserMapper {


    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        return user;
    }

    public static UserDto toDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId() );
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;

    }

}
