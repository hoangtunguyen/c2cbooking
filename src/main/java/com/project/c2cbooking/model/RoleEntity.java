package com.project.c2cbooking.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    Integer id;

    @Column(name = "role_name")
    String roleName;

    @Column(name = "del_flag")
    Integer delFlag;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    List<UserEntity> userEntities;
}
