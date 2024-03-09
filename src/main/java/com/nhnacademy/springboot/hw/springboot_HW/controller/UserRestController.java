package com.nhnacademy.springboot.hw.springboot_HW.controller;

import com.nhnacademy.springboot.hw.springboot_HW.domain.User;
import com.nhnacademy.springboot.hw.springboot_HW.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUser(@PathVariable String id){
        return userService.getUser(id);
    }

}
