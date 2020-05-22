package com.project.c2cbooking.request;

import lombok.Data;

import java.util.Collection;

@Data
public class RoomRequest {
    Integer guestCount;
    Integer minPrice;
    Integer maxPrice;
    String  location;
    String nameRoom;
    Collection<Integer> roomTypeId;
}
