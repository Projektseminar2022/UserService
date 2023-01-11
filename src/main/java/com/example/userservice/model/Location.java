package com.example.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;
    private String location;
    private float longitude;
    private float latitude;


}
