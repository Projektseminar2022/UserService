package com.example.userservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long location_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String location;
    private float longitude;
    private float latitude;


}
