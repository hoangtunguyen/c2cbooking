package com.project.c2cbooking.controller;

import com.project.c2cbooking.request.BookingRequest;
import com.project.c2cbooking.service.imp.BookingServiceImp;
import com.project.c2cbooking.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {
    @Autowired
    private RoomServiceImp roomServiceImp;

    @Autowired
    private BookingServiceImp bookingServiceImp;

    @GetMapping("/room/favorite/{count}")
    public ResponseEntity<?> home(@PathVariable Integer count){
        return ResponseEntity.ok(roomServiceImp.topFavoriteRooms(count));
    }

    @GetMapping("/room/detail/{id}")
    public ResponseEntity<?> findOneRoom(@PathVariable Integer id){
        return ResponseEntity.ok(roomServiceImp.findOneRoom(id));
    }

    @GetMapping("/room/viewAll")
    public ResponseEntity<?> viewAllRooms(){
        return ResponseEntity.ok(roomServiceImp.viewAllRooms());
    }

    @PostMapping("/bookRoom")
    public String bookRoom(@RequestBody BookingRequest bookingRequest){
        try {
            bookingServiceImp.bookRoom(bookingRequest);
            return "success";
        }catch (Exception e){
            return ("Exception: " + e);
        }
    }


}
