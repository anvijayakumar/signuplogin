package com.example.signuplogin.service;

import com.example.signuplogin.dto.LoginRequestDto;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<Object> login(LoginRequestDto loginRequestDto);
}
