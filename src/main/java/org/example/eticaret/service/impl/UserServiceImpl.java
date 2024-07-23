package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.UserDto;
import org.example.eticaret.entity.User;
import org.example.eticaret.repository.UserRepository;
import org.example.eticaret.service.UserService;
import org.example.eticaret.service.mapper.UserServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        User user = UserServiceMapper.toEntity(userDto);
        userRepository.save(user);
        return UserServiceMapper.toDto(user);

    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        User user = userRepository.findById(id).get();


        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        User updatedUser=userRepository.save(user);

        return UserServiceMapper.toDto(updatedUser) ;
    }


    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).get();
        return UserServiceMapper.toDto(user);
    }


    @Override
    public List<UserDto> getAll() {
        return null;
    }


    @Override
    public void delete(Long id) {

    }
}
