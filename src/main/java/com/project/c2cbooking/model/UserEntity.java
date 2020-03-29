package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    int id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @ManyToOne
    @JoinColumn(name = "role")
    RoleEntity role;


}
