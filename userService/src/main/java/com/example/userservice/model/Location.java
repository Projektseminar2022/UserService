package com.example.userservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    private String location;
    private float longitude;
    private float latitude;


}
