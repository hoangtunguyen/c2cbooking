package com.project.c2cbooking.request;

import lombok.Data;

@Data
public class RoomRequest {
    Integer guestCount;
    Integer minPrice;
    Integer maxPrice;
    String  location;
}
