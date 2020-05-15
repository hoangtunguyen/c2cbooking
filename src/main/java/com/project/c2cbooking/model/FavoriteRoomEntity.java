package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "favorite_room")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FavoriteRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_room_id")
    Integer id;

    @Column(name = "title")
    String title;

    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @Column(name = "del_flag", columnDefinition="BOOLEAN DEFAULT false")
    Boolean delFlag;
}
