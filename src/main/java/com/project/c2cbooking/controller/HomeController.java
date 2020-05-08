package com.project.c2cbooking.controller;
import com.project.c2cbooking.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
    @Autowired
    private RoomServiceImp roomServiceImp;
    @GetMapping("/")
    public ResponseEntity<?> home(HttpServletRequest request){
        return ResponseEntity.ok(roomServiceImp.topFavoriteRooms(5));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOneRoom(@PathVariable Integer id){
        return ResponseEntity.ok(roomServiceImp.findOneRoom(id));
    }
    @GetMapping("/user")
    public String user(){
        return ("<h1>User</h1");
    }
    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Admin</h1");
    }
}
