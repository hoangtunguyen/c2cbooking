package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "email")
    String email;
    @ManyToOne
    @JoinColumn(name = "role")
    RoleEntity role;
    @Column(name = "del_flag")
    Integer delFlag;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    List<PhotoEntity> photoEntities;

    @OneToMany(mappedBy = "userEntity")
    List<RoomEntity> roomEntities;

    @OneToMany(mappedBy = "userEntity")
    List<ReviewEntity> reviewEntities;

    @OneToMany(mappedBy = "userEntity")
    List<BookingEntity> bookingEntities;
}
