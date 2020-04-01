package com.project.c2cbooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "room_amenity")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomAmenityEntity extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_amenity_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name = "amenity_id")
    AmenityEntity amenityEntity;

    @Column(name = "del_flag")
    Integer del_flag;
}
