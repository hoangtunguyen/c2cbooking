package com.project.c2cbooking.controller;

import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.request.BookingRequest;
import com.project.c2cbooking.request.FavoriteRequest;
import com.project.c2cbooking.request.RoomRequest;
import com.project.c2cbooking.response.FavoriteResponse;
import com.project.c2cbooking.response.RoomResponse;
import com.project.c2cbooking.service.imp.BookingServiceImp;
import com.project.c2cbooking.service.imp.FavoriteServiceImp;
import com.project.c2cbooking.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomServiceImp roomServiceImp;

    @Autowired
    private BookingServiceImp bookingServiceImp;

    @Autowired
    private FavoriteServiceImp favoriteServiceImp;

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

    @GetMapping("/room/search")
    public ResponseEntity<?> searchRoom(@RequestBody RoomRequest roomRequest){
        List<RoomResponse> rooms = roomServiceImp.searchRoom(roomRequest);
        return ResponseEntity.ok(rooms);
    }


    @GetMapping("/room/listFavorite/{userId}")
    public ResponseEntity<?> getListFavorite(@PathVariable Integer userId){
        List<FavoriteResponse> list = favoriteServiceImp.getFavoriteList(userId);
        return ResponseEntity.ok(list);
    }
    @PostMapping("room/addFavorite")
    public String addFavorite(@RequestBody FavoriteRequest favoriteRequest){
        try {
            favoriteServiceImp.addFavorite(favoriteRequest);
            return "success";
        }catch (Exception e){
            return ("Exception: " + e);
        }
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
