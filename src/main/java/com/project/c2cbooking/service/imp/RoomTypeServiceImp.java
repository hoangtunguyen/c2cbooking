package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.model.RoomTypeEntity;
import com.project.c2cbooking.repository.RoomTypeRepository;
import com.project.c2cbooking.response.RoomTypeResponse;
import com.project.c2cbooking.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomTypeServiceImp implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomTypeResponse> viewAllRoomType() {
        List<RoomTypeEntity> roomTypeEntities = roomTypeRepository.findAll();
        List<RoomTypeResponse> responses = roomTypeEntities.stream().map(data ->
        {
            RoomTypeResponse response = new RoomTypeResponse();
            response.setId(data.getId());
            response.setTypename(data.getName());
            response.setUrlIcon(data.getUrlIcon());
           return response;
        }).collect(Collectors.toList());
        return responses;
    }
}
