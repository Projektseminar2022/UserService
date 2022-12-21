package com.example.userservice.controller;


import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    @RolesAllowed("seminarUser")
    public ResponseEntity<User>save(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/user")
    @RolesAllowed("seminarUser")
    public ResponseEntity<List<User>>findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
