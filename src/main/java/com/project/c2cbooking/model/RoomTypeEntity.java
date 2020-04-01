package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room_type")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomTypeEntity extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "tag")
    String tag;

    @Column(name = "del_flag")
    Integer delFlag;

    @OneToMany(mappedBy = "roomTypeEntity")
    List<RoomEntity> roomEntities;

}
