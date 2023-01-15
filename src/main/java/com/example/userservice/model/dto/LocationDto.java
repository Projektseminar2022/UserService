package com.example.userservice.model.dto;

import com.example.userservice.model.Location;
import com.example.userservice.model.User;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class LocationDto {

    @NotNull
    private String location;
    @NotNull
    private float longitude;
    @NotNull
    private float latitude;


    public static Location fromLocationDto(User user,LocationDto locationDto){
        return new Location()
                .setUser(user)
                .setLocation(locationDto.getLocation())
                .setLongitude(locationDto.getLongitude())
                .setLatitude(locationDto.getLongitude())
                ;



    }
    public static LocationDto fromLocation(Location location){
        return new LocationDto()
                .setLocation(location.getLocation())
                .setLongitude(location.getLongitude())
                .setLatitude(location.getLongitude())
                ;



    }

}

