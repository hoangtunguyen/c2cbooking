package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.convert.AmenityConvert;
import com.project.c2cbooking.convert.BookingConvert;
import com.project.c2cbooking.model.AmenityEntity;
import com.project.c2cbooking.repository.AmenityRepository;
import com.project.c2cbooking.response.AmenityResponse;
import com.project.c2cbooking.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmenityServiceImp implements AmenityService {
    @Autowired
    private AmenityRepository amenityRepository;
    @Override
    public List<AmenityResponse> viewAllAmenity() {
        List<AmenityEntity> list = amenityRepository.findAll();
        return list.stream().map((value) -> {
            AmenityResponse response = new AmenityResponse();
            response.setId(value.getId());
            response.setIconUrl(value.getIconUrl());
            response.setName(value.getName());
            return response;
        }).collect(Collectors.toList());
    }
}
