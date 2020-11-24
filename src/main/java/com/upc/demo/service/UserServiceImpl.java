package com.upc.demo.service;

import com.upc.demo.domain.model.User;
import com.upc.demo.domain.repository.UserRepository;
import com.upc.demo.domain.service.UserService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("User","Id", id));
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User updateUser(Long userId, User userRequest) {
        //TODO:Implement method
        return null;
    }

    @Override
    public ResponseEntity<?> deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
