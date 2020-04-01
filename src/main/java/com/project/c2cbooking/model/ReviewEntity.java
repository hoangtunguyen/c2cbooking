package com.project.c2cbooking.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "review")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewEntity extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomEntity roomEntity;


    @Column(name = "comment")
    String comment;

    @Column(name = "rating")
    BigDecimal rating;

    @Column(name = "del_flag")
    Integer delFlag;


}
