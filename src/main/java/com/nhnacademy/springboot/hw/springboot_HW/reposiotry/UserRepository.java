package com.nhnacademy.springboot.hw.springboot_HW.reposiotry;

import com.nhnacademy.springboot.hw.springboot_HW.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean matches(String id, String pwd);
}
