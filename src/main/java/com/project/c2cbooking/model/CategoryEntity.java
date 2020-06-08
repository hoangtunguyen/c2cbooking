//package com.project.c2cbooking.model;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "category")
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class CategoryEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "category_id")
//    Integer id;
//
//    @Column(name = "name")
//    String name;
//
//
//    @Column(name = "del_flag", columnDefinition="BOOLEAN DEFAULT false")
//    Boolean delFlag;
//
//    @ManyToOne
//    @JoinColumn(name = "room_type_id")
//    RoomTypeEntity roomTypeEntity;
//
//    @OneToMany(mappedBy = "categoryEntity")
//    List<RoomEntity> roomEntities;
//
//
//}
