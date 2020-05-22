package com.project.c2cbooking.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomResponse {
    Integer id;
    String name;
    String categoryRoom;
    Integer votedCount;
    String rating;
    BigDecimal price;
    String urlImage;
    String city;
    double lat;
    double lng;
}
