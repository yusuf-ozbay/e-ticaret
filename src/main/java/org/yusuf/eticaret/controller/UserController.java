package org.yusuf.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yusuf.eticaret.dto.UserDto;
import org.yusuf.eticaret.request.UserRequest;
import org.yusuf.eticaret.response.UserResponse;
import org.yusuf.eticaret.service.UserService;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest userRequest){

        return toResponse(userService.save(toDto(userRequest)));
    }

    public UserResponse toResponse(UserDto user){
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        return userResponse;
    }
    public UserDto toDto (UserRequest userRequest){
        UserDto userDto=new UserDto();
        userDto.setName(userRequest.getName());
        userDto.setSurname(userRequest.getSurname());
        return userDto;
    }



}
