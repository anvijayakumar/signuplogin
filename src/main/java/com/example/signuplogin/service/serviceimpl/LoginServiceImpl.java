package com.example.signuplogin.service.serviceimpl;

import com.example.signuplogin.dto.LoginRequestDto;
import com.example.signuplogin.entity.User;
import com.example.signuplogin.repository.UserRepository;
import com.example.signuplogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<Object> login(LoginRequestDto loginRequestDto) {
        Optional<User> userOptional = userRepository.findByEmailIgnoreCase(loginRequestDto.getEmail());

        if (userOptional.isEmpty()) {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            return new ResponseEntity<>("Invalid Password", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Login successful. Welcome, " + user.getName() + "!", HttpStatus.OK);
    }
}
