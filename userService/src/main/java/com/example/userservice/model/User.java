package com.example.userservice.model;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String city;
    private String country;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Location> prefLocations;


}
