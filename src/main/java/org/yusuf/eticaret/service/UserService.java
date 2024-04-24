package org.yusuf.eticaret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.dto.UserDto;
import org.yusuf.eticaret.entity.User;
import org.yusuf.eticaret.repository.UserRepository;
import org.yusuf.eticaret.service.mapper.UserMapper;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public User findById(long id){

        User user=userRepository.findById(id).get();
        return user;
    }


    public UserDto save(UserDto userDto) {
        User user= UserMapper.toEntity(userDto);
        user=userRepository.save(user);
        return UserMapper.toDto(user);
    }

}

