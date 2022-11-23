package com.example.userservice.services;


import com.example.userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.userservice.repositories.UserRepository;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User deleteById(Integer id){
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }
}