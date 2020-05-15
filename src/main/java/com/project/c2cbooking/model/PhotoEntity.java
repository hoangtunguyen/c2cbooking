package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photo")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    Integer id;

    @Column(name = "url")
    String url;

    @Column(name = "decription")
    String description;

    @Column(name = "del_flag", columnDefinition="BOOLEAN DEFAULT false")
    Boolean delFlag;


    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomEntity roomEntity;
}
