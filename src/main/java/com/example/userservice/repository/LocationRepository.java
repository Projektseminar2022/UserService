package com.example.userservice.repository;

import com.example.userservice.model.Location;
import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {


    @Transactional
    //@Query("delete from Location l where l.location = :location AND l.user = :user ")
    Optional <Location>deleteLocationByLocationAndUser(String location,User user);
}
