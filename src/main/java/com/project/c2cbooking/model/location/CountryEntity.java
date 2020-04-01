package com.project.c2cbooking.model.location;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "del_flag")
    Integer delFlag;

    @OneToMany(mappedBy = "countryEntity")
    List<CityEntity> cityEntities;
}
