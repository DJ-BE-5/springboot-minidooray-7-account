package com.nhnacademy.springboot.hw.springboot_HW.domain.request;

import lombok.Data;
import lombok.Setter;
import lombok.Value;

@Data
@Value
@Setter
public class LoginRequest {
    private String id;
    private String pw;
    private String email;
}
