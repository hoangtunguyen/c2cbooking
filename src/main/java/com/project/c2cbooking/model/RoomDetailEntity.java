//package com.project.c2cbooking.model;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "room_detail")
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class RoomDetailEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "room_detail_id")
//    Integer id;
//
//    @Column(name = "guest_count")
//    Integer guestCount;
//
//    @Column(name = "bedroom_count")
//    Integer bedroomCount;
//
//    @Column(name = "bed_count")
//    Integer bedCount;
//
//    @Column(name = "bathroom_count")
//    Integer bathroomCount;
//
//
//    @Column(name = "del_flag", columnDefinition="BOOLEAN DEFAULT false")
//    Boolean delFlag;
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roomDetailEntity")
//    RoomEntity roomEntity;
//}
