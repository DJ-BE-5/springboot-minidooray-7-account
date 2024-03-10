package com.nhnacademy.springboot.hw.springboot_HW.controller;

import com.nhnacademy.springboot.hw.springboot_HW.domain.request.UserRequest;
import com.nhnacademy.springboot.hw.springboot_HW.domain.User;
import com.nhnacademy.springboot.hw.springboot_HW.domain.response.UserIdPwResponse;
import com.nhnacademy.springboot.hw.springboot_HW.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @PostMapping("/login")
    public UserIdPwResponse doLogin(@RequestParam("id") String id,
                                    @RequestParam("pw") String pw,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
        if (userService.matches(id, pw)) {
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);

        }
        return new UserIdPwResponse(id, pw);

    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void doRegisterUser(@RequestBody UserRequest userRequest){
        User user = new User(userRequest.getId(), userRequest.getPw(), userRequest.getEmail());
        userService.createUser(user);
    }

}
