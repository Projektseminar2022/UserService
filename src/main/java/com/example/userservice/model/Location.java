package com.example.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
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
    //@Column(name="location",unique = true)
    private String location;
    private float longitude;
    private float latitude;



}
