package com.project.c2cbooking.controller;

import com.project.c2cbooking.model.UserEntity;
import com.project.c2cbooking.repository.UserRepository;
import com.project.c2cbooking.request.UserRequest;
import com.project.c2cbooking.response.AmenityResponse;
import com.project.c2cbooking.response.CityResponse;
import com.project.c2cbooking.response.UserResponse;
import com.project.c2cbooking.service.CityService;
import com.project.c2cbooking.service.imp.AmenityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SupportController {
    @Autowired
    private CityService cityService;

    @Autowired
    private AmenityServiceImp amenityServiceImp;

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest request){
        UserResponse response = new UserResponse();
        try {
            UserEntity userEntity = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
            response.setUserId(userEntity.getId());
            response.setUserName(userEntity.getUsername());
            response.setEmail(userEntity.getEmail());
        }catch (Exception e){
            return new ResponseEntity<>(Collections.singletonMap("message", "Username or Password are incorrect"), HttpStatus.NOT_FOUND);
        }


        return  ResponseEntity.ok(response);
    }

    @GetMapping("/city/viewAll")
    public ResponseEntity<?> getAllCity() {
        List<CityResponse> responses = cityService.viewAllCity();
        return ResponseEntity.ok(responses);
    }
    @GetMapping("/amenity/viewAll")
    public ResponseEntity<?> getAllAmenity() {
        List<AmenityResponse> responses = amenityServiceImp.viewAllAmenity();
        return ResponseEntity.ok(responses);
    }

}
