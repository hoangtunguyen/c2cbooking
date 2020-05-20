package com.project.c2cbooking.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomFullResponse {
    Integer id;
    String name;
    String categoryRoom;
    Integer votedCount;
    String rating;
    BigDecimal price;
    String urlImage;

    String address;
    double lat;
    double lng;

    Integer guestCount;
    Integer bedroomCount;
    Integer bedCount;
    Integer bathroomCount;

    String ownerName;
    Integer minGuestCount;
    BigDecimal increasingPrice;
    BigDecimal serviceFee;
    List<AmenityResponse> amenityResponseList;
}
