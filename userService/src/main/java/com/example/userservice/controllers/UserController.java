package com.example.userservice.controllers;

import com.example.userservice.entities.User;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="adduser",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RolesAllowed("user")
    public Mono<User> addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping(path ="/getuser/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RolesAllowed("user")
    public Mono<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
    @GetMapping(path="/getusers",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RolesAllowed("admin")
    public Flux<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path="deleteuser",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @RolesAllowed("admin")
    public Mono<Void> deleteById(Integer id){
        return userService.deleteById(id);
    }

    @PostMapping(path="/changepass/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @RolesAllowed("admin")
    public Mono<User> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
