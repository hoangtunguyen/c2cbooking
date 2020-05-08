package com.project.c2cbooking.controller;

import com.project.c2cbooking.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    private RoomServiceImp roomServiceImp;

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



}
