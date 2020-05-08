package com.project.c2cbooking.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {
    String checkInDate;
    String checkOutDate;
    String bookingDate;
    Integer roomId;
    Integer userId;
    String totalCost;
}
