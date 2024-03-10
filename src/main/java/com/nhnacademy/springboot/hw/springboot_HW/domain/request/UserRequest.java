package com.nhnacademy.springboot.hw.springboot_HW.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;
import lombok.Value;

@Value
@Data
@Setter
public class UserRequest {
    @JsonProperty("id")
    private String id;

    private String pw;

    private String email;
}
