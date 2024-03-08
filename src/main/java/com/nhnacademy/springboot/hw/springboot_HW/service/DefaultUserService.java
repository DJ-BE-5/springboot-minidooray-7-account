package com.nhnacademy.springboot.hw.springboot_HW.service;

import com.nhnacademy.springboot.hw.springboot_HW.domain.User;
import com.nhnacademy.springboot.hw.springboot_HW.reposiotry.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService{

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        User newUser = new User(user.getId(), user.getPw(), user.getEmail(), user.getUserAdmin(), user.getStatus());
        return userRepository.save(newUser);
    }

    @Override
    public void modifyUser(User user) {
        User dbUser = getUser(user.getId()).orElseThrow(()->{
            return new RuntimeException("회원 없음");
        });
        dbUser.setPw(user.getPw());
        dbUser.setEmail(user.getEmail());
        dbUser.setUserAdmin(user.getUserAdmin());
        dbUser.setStatus(user.getStatus());
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
