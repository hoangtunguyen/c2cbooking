package com.project.c2cbooking.convert;

import com.project.c2cbooking.model.BookingEntity;
import com.project.c2cbooking.response.BookingResponse;
import com.project.c2cbooking.util.Util;

public class BookingConvert {
    public static BookingResponse convert(BookingEntity bookingEntity){
        BookingResponse response = new BookingResponse();
        response.setId(bookingEntity.getId());
        response.setCheckInDate(Util.convertTimestampToString(bookingEntity.getCheckInDate()));
        response.setCheckOutDate(Util.convertTimestampToString(bookingEntity.getCheckOutDate()));
        response.setBookingDate(Util.convertTimestampToString(bookingEntity.getBookingDate()));
        response.setTotalCost(bookingEntity.getTotalCost());
        response.setRoomResponse(RoomConvert.convertFullData(bookingEntity.getRoomEntity()));
        response.setGuestCount(bookingEntity.getGuestCount());
        response.setInfantCount(bookingEntity.getInfantCount());
        response.setNameGuest(bookingEntity.getUserEntity().getUsername());
        return response;
    }
}
