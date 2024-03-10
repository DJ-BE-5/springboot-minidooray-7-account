package com.nhnacademy.springboot.hw.springboot_HW.domain.response;

import lombok.*;

@Data
@NoArgsConstructor
public class UserIdPwResponse {
    private String id;
    private String pw;

    public UserIdPwResponse(String id, String pw) {
        this.id = id;
        this.pw=pw;
    }
}
