package com.project.c2cbooking.service;

import com.project.c2cbooking.request.BookingRequest;
import com.project.c2cbooking.response.BookingResponse;

import java.sql.Timestamp;
import java.util.List;

public interface BookingService {
    void bookRoom(BookingRequest bookingRequest);
    List<BookingResponse> getBookingByUserId(Integer userId);
    BookingResponse getDetailBooking(Integer bookingId);

    List<BookingResponse> getBookingByOwnerIdAndCheckInDate(Integer ownerId, String checkInDate);

}
