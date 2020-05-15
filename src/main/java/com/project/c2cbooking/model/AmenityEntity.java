package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "amenity")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AmenityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "icon_url")
    String iconUrl;

    @Column(name = "del_flag", columnDefinition="BOOLEAN DEFAULT false")
    Boolean delFlag;

    @OneToMany(mappedBy = "amenityEntity")
    List<RoomAmenityEntity> amenityEntities;


}
