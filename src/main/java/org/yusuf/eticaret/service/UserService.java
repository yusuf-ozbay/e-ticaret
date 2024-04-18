package org.yusuf.eticaret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.dto.UserDto;
import org.yusuf.eticaret.entity.User;
import org.yusuf.eticaret.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(long id){

        User user=userRepository.findById(id).get();
        return user;
    }


    public UserDto save(UserDto userDto) {
        User user=toEntity(userDto);
        user=userRepository.save(user);
        return toDto(user);
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        return user;
    }

    public UserDto toDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId() );
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;

    }
}

