package com.project.c2cbooking.model.location;

import com.project.c2cbooking.model.Auditable;
import com.project.c2cbooking.model.RoomEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationEntity  extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    Integer id;

    @Column(name = "lat")
    String lat;

    @Column(name = "lng")
    String lng;

    @Column(name = "street")
    String street;

    @ManyToOne
    @JoinColumn(name = "city_id")
    CityEntity cityEntity;

    @Column(name = "del_flag")
    Integer delFlag;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locationEntity")
    RoomEntity roomEntity;
}
