package com.project.c2cbooking.model;

import com.project.c2cbooking.model.location.LocationEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "room")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "service_fee")
    BigDecimal serviceFee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_detail_id", nullable = false, unique = true)
    RoomDetailEntity roomDetailEntity;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false, unique = true)
    LocationEntity locationEntity;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    CategoryEntity categoryEntity;

    @Column(name = "note")
    String note;

    @Column(name = "description")
    String description;

    @Column(name = "min_guest_count")
    Integer minGuestCount;

    @Column(name = "fee_increasing_person")
    BigDecimal feeIncreasingPerson;

    @Column(name = "del_flag")
    Integer delFlag;

    @OneToMany(mappedBy = "roomEntity")
    List<PhotoEntity> photoEntities;

    @OneToMany(mappedBy = "roomEntity")
    List<ReviewEntity> reviewEntities;

    @OneToMany(mappedBy = "roomEntity")
    List<RoomAmenityEntity> roomAmenityEntities;

    @OneToMany(mappedBy = "roomEntity")
    List<BookingEntity> bookingEntities;

    @OneToMany(mappedBy = "roomEntity")
    List<FavoriteRoomEntity> favoriteRoomEntities;
}
