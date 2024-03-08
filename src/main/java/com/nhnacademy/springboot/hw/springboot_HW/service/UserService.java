package com.nhnacademy.springboot.hw.springboot_HW.service;

import com.nhnacademy.springboot.hw.springboot_HW.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUser(String id);

    User createUser(User user);

    void modifyUser(User user);

    void deleteUser(String id);



}
