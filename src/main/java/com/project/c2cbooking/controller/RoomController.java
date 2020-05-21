package com.project.c2cbooking.controller;

import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.request.BookingRequest;
import com.project.c2cbooking.request.FavoriteRequest;
import com.project.c2cbooking.request.RoomRequest;
import com.project.c2cbooking.response.BookingResponse;
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
    public ResponseEntity<?> searchRoom(@RequestParam Integer guestCount, @RequestParam Integer minPrice, @RequestParam Integer maxPrice, String location, String nameRoom){
        RoomRequest request = new RoomRequest();
        request.setGuestCount(guestCount);
        request.setMinPrice(minPrice);
        request.setMaxPrice(maxPrice);
        request.setLocation(location);
        request.setNameRoom(nameRoom);
        List<RoomResponse> rooms = roomServiceImp.searchRoom(request);
        return ResponseEntity.ok(rooms);
    }


    @GetMapping("/room/listFavorite")
    public ResponseEntity<?> getListFavorite(@RequestParam Integer userId){
        List<FavoriteResponse> list = favoriteServiceImp.getFavoriteList(userId);
        return ResponseEntity.ok(list);
    }
    @PostMapping("room/addOrDeleteFavorite")
    public String addOrDeleteFavorite(@RequestBody FavoriteRequest favoriteRequest){
        try {
            if (!favoriteServiceImp.isExist(favoriteRequest.getUserId(), favoriteRequest.getRoomId())){
                favoriteServiceImp.addFavorite(favoriteRequest);
                return "added";
            }
            favoriteServiceImp.deleteFavorite(favoriteRequest.getUserId(), favoriteRequest.getRoomId());
            return "deleted";
        }catch (Exception e){
            return ("Exception: " + e);
        }
    }
    @GetMapping("room/isFavorite")
    public boolean isFavorite(@RequestParam Integer userId, @RequestParam Integer roomId){
        return  favoriteServiceImp.isExist(userId, roomId);
    }

    @PostMapping("/booking")
    public String bookRoom(@RequestBody BookingRequest bookingRequest){
        try {
            bookingServiceImp.bookRoom(bookingRequest);
            return "success";
        }catch (Exception e){
            return ("Exception: " + e);
        }
    }

    @GetMapping("/booking/list")
    public ResponseEntity<?> getBookingByUserId(@RequestParam Integer userId){
            List<BookingResponse> responses = bookingServiceImp.getBookingByUserId(userId);
            return ResponseEntity.ok(responses);
    }

}
