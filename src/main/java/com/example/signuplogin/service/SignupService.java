package com.example.signuplogin.service;

import com.example.signuplogin.dto.SignupRequestDto;
import org.springframework.http.ResponseEntity;

public interface SignupService {
    ResponseEntity<Object> signup(SignupRequestDto signupRequestDto);
}
