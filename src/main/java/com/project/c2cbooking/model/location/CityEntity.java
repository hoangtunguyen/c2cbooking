package com.project.c2cbooking.model.location;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "del_flag")
    Integer delFlag;

    @ManyToOne
    @JoinColumn(name = "country_id")
    CountryEntity countryEntity;

    @OneToMany(mappedBy = "cityEntity")
    List<LocationEntity> locationEntities;
}
