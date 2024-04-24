package org.yusuf.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yusuf.eticaret.controller.mapper.UserMapper;
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

        return UserMapper.toResponse(userService.save(UserMapper.toDto(userRequest)));
    }




}
