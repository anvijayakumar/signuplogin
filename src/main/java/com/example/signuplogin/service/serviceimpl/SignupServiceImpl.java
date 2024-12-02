package com.example.signuplogin.service.serviceimpl;

import com.example.signuplogin.dto.SignupRequestDto;
import com.example.signuplogin.entity.User;
import com.example.signuplogin.repository.UserRepository;
import com.example.signuplogin.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignupServiceImpl implements SignupService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SignupServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<Object> signup(SignupRequestDto signupRequestDto) {
        if (signupRequestDto.getName() == null || signupRequestDto.getName().isEmpty() ||
                signupRequestDto.getEmail() == null || signupRequestDto.getEmail().isEmpty() ||
                signupRequestDto.getPassword() == null || signupRequestDto.getPassword().isEmpty()) {
            return new ResponseEntity<>("FirstName, LastName, Email, and Password are compulsory.", HttpStatus.BAD_REQUEST);
        }

        Optional<User> existingUser = userRepository.findByEmailIgnoreCase(signupRequestDto.getEmail());
        if (existingUser.isPresent()) {
            return new ResponseEntity<>("Email is already in use.", HttpStatus.CONFLICT);
        }

        User userEntity = new User();
        userEntity.setName(signupRequestDto.getName());
        userEntity.setEmail(signupRequestDto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));

        userRepository.save(userEntity);
        return new ResponseEntity<>("Signup successful. Welcome, " + signupRequestDto.getName() + "!", HttpStatus.CREATED);
    }
}
