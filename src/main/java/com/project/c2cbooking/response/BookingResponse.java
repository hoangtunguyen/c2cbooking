package com.project.c2cbooking.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingResponse {
    Integer Id;
    String checkInDate;
    String checkOutDate;
    String bookingDate;
    RoomResponse roomResponse;
    BigDecimal totalCost;
    Integer guestCount;
    Integer infantCount;
}
