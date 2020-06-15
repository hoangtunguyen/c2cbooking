package com.project.c2cbooking.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AddRoomRequest {
    Integer roomId;
    String roomName;
    BigDecimal price;
    BigDecimal serviceFee;
    Integer guestCount;
    Integer bedroomCount;
    Integer bedCount;
    Integer bathroomCount;
    LocationRequest location;
    Integer ownerId;
    Integer roomTypeId;
    String description;
    Integer minGuestCount;
    BigDecimal feeIncreasingPerson;
    List<Integer> amenityIdList;
    String urlImage;
}
