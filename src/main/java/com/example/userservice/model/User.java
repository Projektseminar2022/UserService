package com.example.userservice.model;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Entity
@Table

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String keycloakId;
    private String lastName;
    private String firstName;
    @Column(name="email",nullable = false, unique = true)
    private String email;
    private String city;
    private String country;
    @OneToMany(cascade = {CascadeType.REMOVE},mappedBy = "user", fetch = FetchType.EAGER)
    private List<Location> prefLocations;


}
