package com.upc.demo.domain.service;

import com.upc.demo.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long userId, User userRequest);
    ResponseEntity<?> deleteUserById(Long id);
}
