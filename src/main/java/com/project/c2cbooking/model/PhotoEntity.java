package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photo")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhotoEntity extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    Integer id;

    @Column(name = "url")
    String url;

    @Column(name = "decription")
    String description;

    @Column(name = "del_flag")
    Integer delFlag;

    @ManyToOne
    @JoinColumn(name = "added_by_user_id")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomEntity roomEntity;
}
