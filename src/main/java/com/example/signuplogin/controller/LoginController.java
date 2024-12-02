package com.example.signuplogin.controller;

import com.example.signuplogin.dto.LoginRequestDto;
import com.example.signuplogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDTO) {

        Object Result = loginService.login(loginRequestDTO);

        return ResponseEntity.ok(Result);
    }
}
