package com.example.userservice.controller;


import com.example.userservice.model.User;
import com.example.userservice.model.dto.UserDto;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.services.KeycloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/user")
    @PermitAll
    public ResponseEntity<Object>createUser(@Valid @RequestBody UserDto user){
        UserRepresentation newUser = keycloakService.registerUserInKeycloak(user);
        if(userRepository.findFirstByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("User already exists");
        }
        userRepository.save(UserDto.fromUserDto(user, newUser.getId()));
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/user")
    @RolesAllowed("user")
    public ResponseEntity<User>findCurrentUser(){
        return ResponseEntity.ok( userRepository.findFirstByKeycloakId(keycloakService.getId()).get());
    }


    @DeleteMapping("/user")
    @RolesAllowed("user")
    public ResponseEntity<User>deleteCurrentUser(){

        return ResponseEntity.ok( userRepository.deleteByKeycloakId(keycloakService.getId()));
    }
}
