package com.project.c2cbooking.service;

import com.project.c2cbooking.request.BookingRequest;
import com.project.c2cbooking.response.BookingResponse;

import java.util.List;

public interface BookingService {
    void bookRoom(BookingRequest bookingRequest);
    List<BookingResponse> getBookingByUserId(Integer userId);
    BookingResponse getDetailBooking(Integer bookingId);
}
