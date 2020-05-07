package com.project.c2cbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {
    @GetMapping("/homes")
    public String home(){
        return "Home";
    }
}
