package com.nhnacademy.springboot.hw.springboot_HW.domain;

import lombok.*;

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
    private String id;

    private String pw;

    private String email;

    private int userAdmin;

    private String status;


}
