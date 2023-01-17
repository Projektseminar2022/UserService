package com.example.userservice.repository;

import com.example.userservice.model.Location;
import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findFirstByKeycloakId(String id);

    Optional<User> findFirstByEmail(String email);
    @Transactional
    User deleteByKeycloakId(String id);
}
