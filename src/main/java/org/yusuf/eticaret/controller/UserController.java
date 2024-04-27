package org.yusuf.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yusuf.eticaret.controller.mapper.UserMapper;
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
    public UserResponse save(@RequestBody UserRequest userRequest) {
        return UserMapper.toResponse(userService.save(UserMapper.toDto(userRequest)));
    }


    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable long id){
        return UserMapper.toResponse(userService.getById(id));
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable long id ,@RequestBody UserRequest userRequest){
        return UserMapper.toResponse(userService.update(id,UserMapper.toDto(userRequest) ));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
       userService.delete(id);
        return "SİLME İŞLEMİ BAŞARILIDIR";
    }



}
