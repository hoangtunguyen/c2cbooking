package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.model.location.CityEntity;
import com.project.c2cbooking.repository.CityRepository;
import com.project.c2cbooking.response.CityResponse;
import com.project.c2cbooking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CityServiceImp implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityResponse> viewAllCity() {
        List<CityEntity> entityList = cityRepository.findAll();
        return entityList.stream().map((value) -> {
            CityResponse response = new CityResponse();
            response.setId(value.getId());
            response.setCityName(value.getName());
            return response;
        }).collect(Collectors.toList());
    }
}
