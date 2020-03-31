package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    Integer id;

    @Column(name = "lat")
    String lat;

    @Column(name = "lng")
    String lng;

    @Column(name = "country")
    String country;

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "del_flag")
    Integer delFlag;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locationEntity")
    RoomEntity roomEntity;
}
