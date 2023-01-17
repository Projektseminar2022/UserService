package com.example.userservice.controller;

import com.example.userservice.model.Location;
import com.example.userservice.model.User;
import com.example.userservice.model.dto.LocationDto;
import com.example.userservice.model.dto.UserDto;
import com.example.userservice.repository.LocationRepository;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.services.KeycloakService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import static com.example.userservice.model.dto.LocationDto.fromLocationDto;
@Slf4j
@RestController
public class LocationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/location")
    @RolesAllowed("user")
    public ResponseEntity<Location> saveLocation(@Valid @RequestBody LocationDto locationDto){
        User user =userRepository.findFirstByKeycloakId(keycloakService.getId()).orElseThrow();

        return ResponseEntity.ok(locationRepository.save(fromLocationDto(user,locationDto)));
    }



    @DeleteMapping("/location")
    @RolesAllowed("user")
    public ResponseEntity<Location>deleteLocation(@Valid @RequestBody LocationDto locationDto){
        User user =userRepository.findFirstByKeycloakId(keycloakService.getId()).orElseThrow();

        return ResponseEntity.ok(locationRepository.deleteLocationByLocationAndUser(fromLocationDto(user,locationDto).getLocation(),user).get());
    }
}
