package com.example.signuplogin.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {

    private String name;
    private String email;
    //@NotEmpty(message = "Password should not be empty")
    private String password;

}
