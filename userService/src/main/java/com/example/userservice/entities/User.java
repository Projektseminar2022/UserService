package com.example.userservice.entities;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    private int id;
    private String email;
    private String password;

    private String city;
    private String country;

    private String firstName;

    private String lastName;

}