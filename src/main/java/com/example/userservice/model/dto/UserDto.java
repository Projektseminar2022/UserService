package com.example.userservice.model.dto;


import com.example.userservice.model.Location;
import com.example.userservice.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Accessors(chain = true)
public class UserDto {

    @NotNull

    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String city;

    @NotNull
    private String country;


    private List<Location> prefLocations;


    public static User fromUserDto(UserDto userDto, String keycloakId){
        return new User()
            .setFirstName(userDto.getFirstName())
            .setLastName(userDto.getLastName())
            .setCity(userDto.getCity())
            .setCountry(userDto.getCountry())
            .setEmail(userDto.getEmail())
            .setPrefLocations(userDto.getPrefLocations())
            .setKeycloakId(keycloakId)
            ;



    }

}
