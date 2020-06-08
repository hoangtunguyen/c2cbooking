package com.project.c2cbooking.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HostListingResponse {

    RoomResponse roomResponse;
    Integer countBooking;
    BigDecimal totalMoney;
}
