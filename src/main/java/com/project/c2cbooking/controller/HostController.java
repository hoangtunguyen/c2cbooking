package com.project.c2cbooking.controller;

import com.project.c2cbooking.request.AddRoomRequest;
import com.project.c2cbooking.response.BookingResponse;
import com.project.c2cbooking.response.HostListingResponse;
import com.project.c2cbooking.service.imp.BookingServiceImp;
import com.project.c2cbooking.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HostController {
    @Autowired
    private RoomServiceImp roomServiceImp;

    @Autowired
    private BookingServiceImp bookingServiceImp;

    @PostMapping("/host/addRoom")
    public void addRoom(@RequestBody AddRoomRequest addRoomRequest) {
        roomServiceImp.addRoom(addRoomRequest);
    }

    @GetMapping("/host/listings")
    public ResponseEntity<?> getListings(@RequestParam Integer userId) {
        List<HostListingResponse> responses = roomServiceImp.getListRoomsByUserId(userId);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/host/booking/listings")
    public ResponseEntity<?> getBookingByOwnerAndCheckInDate(@RequestParam Integer ownerId, @RequestParam String checkInDate) {
        List<BookingResponse> list = bookingServiceImp.getBookingByOwnerIdAndCheckInDate(ownerId, checkInDate);
        return ResponseEntity.ok(list);
    }

}
