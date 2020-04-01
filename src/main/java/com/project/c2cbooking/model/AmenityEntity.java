package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "amenity")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AmenityEntity extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "icon_url")
    String iconUrl;

    @Column(name = "del_flag")
    Integer delFlag;

    @OneToMany(mappedBy = "amenityEntity")
    List<RoomAmenityEntity> amenityEntities;


}
