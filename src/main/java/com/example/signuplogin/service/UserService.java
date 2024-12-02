package com.example.signuplogin.service;

import com.example.signuplogin.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    ResponseEntity<Object> getUserById(Long id);

    ResponseEntity<Object> updateUser(Long id, User userDetails);

    ResponseEntity<String> deleteUser(Long id);
}
