package com.example.signuplogin.controller;

import com.example.signuplogin.dto.SignupRequestDto;
import com.example.signuplogin.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody SignupRequestDto signupRequestDto) {
        Object result = signupService.signup(signupRequestDto);

        return ResponseEntity.ok(result);
    }
}
