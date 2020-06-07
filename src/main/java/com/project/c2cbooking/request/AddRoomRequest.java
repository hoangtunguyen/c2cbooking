package com.project.c2cbooking.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AddRoomRequest {
    String roomName;
    BigDecimal price;
    BigDecimal serviceFee;
    Integer minGuestCount;
    BigDecimal feeIncreasingPerson;
    Integer guestCount;
    Integer bedroomCount;
    Integer bedCount;
    Integer bathroomCount;
    String description;
    List<Integer> amenityIdList;
    String urlImage;
    Integer ownerId;


}
