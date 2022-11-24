package com.example.userservice.services;


import com.example.userservice.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.userservice.repositories.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public Mono<User> createUser(User user){
        return userRepository.save(user);
    }

    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Mono<Void> deleteById(Integer id){
        return userRepository.deleteById(id);
    }
    public Mono<User> updateUser(User user){
        return userRepository.save(user);
    }
}