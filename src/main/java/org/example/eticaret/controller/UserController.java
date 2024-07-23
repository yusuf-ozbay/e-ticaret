package org.example.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.controller.mapper.UserControllerMapper;
import org.example.eticaret.dto.UserDto;
import org.example.eticaret.request.UserRequest;
import org.example.eticaret.response.UserResponse;
import org.example.eticaret.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserDto userDto = UserControllerMapper.toDto(userRequest);
        return ResponseEntity.ok(UserControllerMapper.toResponse(userService.save(userDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") @RequestBody UserDto userDto, Long userId) {
        UserDto user = userService.update(userId, userDto);
        return ResponseEntity.ok(UserControllerMapper.toResponse(user));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id")  Long id){
        UserDto userDto =userService.getUser(id);
        return ResponseEntity.ok(UserControllerMapper.toResponse(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser() {
        List<UserDto> userDtoList = userService.getAll();

        // UserDto olan Kullanıcıları UserResponse nesnelerine dönüştürmek için stream API kullanıyoruz.
        // userDtoList listesini bir akışa dönüştürüyoruz.
        // .map(UserControllerMapper::toResponse) kısmı, her bir UserDto nesnesini UserResponse nesnesine dönüştürür.
        // .collect(Collectors.toList()) ile dönüşen UserResponse nesnelerini bir listeye toplarız.
        List<UserResponse> userResponseList = userDtoList.stream()
                .map(UserControllerMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long Userid){
        userService.delete(Userid);
        return ResponseEntity.ok("User deleted successdully");
    }

}
