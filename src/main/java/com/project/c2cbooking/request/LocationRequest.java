package com.project.c2cbooking.request;

import com.project.c2cbooking.model.location.CityEntity;
import lombok.Data;

@Data
public class LocationRequest {
    String lat;
    String lng;
    String street;
    Integer cityId;

}
