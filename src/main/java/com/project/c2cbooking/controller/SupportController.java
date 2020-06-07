package com.project.c2cbooking.controller;

import com.project.c2cbooking.response.AmenityResponse;
import com.project.c2cbooking.response.CityResponse;
import com.project.c2cbooking.service.CityService;
import com.project.c2cbooking.service.imp.AmenityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupportController {
    @Autowired
    private CityService cityService;

    @Autowired
    private AmenityServiceImp amenityServiceImp;

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
