package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "booking")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    Integer id;

    @Column(name = "check_in_date")
    Timestamp checkInDate;

    @Column(name = "check_out_date")
    Timestamp checkOutDate;

    @Column(name = "booking_date")
    Timestamp bookingDate;


    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @Column(name = "total_cost")
    BigDecimal totalCost;

    @Column(name = "is_refund")
    Boolean isRefund;

    @Column(name = "cancel_date")
    Timestamp cancelDate;

    @Column(name = "is_paid")
    Boolean isPaid;

    @Column(name = "del_flag")
    Integer delFlag;

}
