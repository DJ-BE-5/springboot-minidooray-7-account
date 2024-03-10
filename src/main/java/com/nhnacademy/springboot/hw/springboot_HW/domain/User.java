package com.nhnacademy.springboot.hw.springboot_HW.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="week_user")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name="user_pw")
    private String pw;

    @Column(name="user_email")
    private String email;

    @Column(name="user_admin")
    private int userAdmin;

    @Column(name="user_status")
    private String status;

    public User(String id, String pw, String email) {
        this.id = id;
        this.pw = pw;
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getEmail() {
        return email;
    }
}
