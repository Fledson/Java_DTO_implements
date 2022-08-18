package com.zihenx.estudoDto.controllers;

import com.zihenx.estudoDto.dto.UserDTO;
import com.zihenx.estudoDto.dto.input_dto.UserInputDTO;
import com.zihenx.estudoDto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> listUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO listUser(@PathVariable Long userId) {
        return userService.findUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserInputDTO user){
        return userService.newUser(user);
    }

}
