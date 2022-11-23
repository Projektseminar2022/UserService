package com.example.userservice.controllers;

import com.example.userservice.entities.User;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("adduser")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/getuser/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
    @GetMapping("/getusers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("deleteuser")
    public User deleteById(Integer id){
        return userService.deleteById(id);
    }
}
