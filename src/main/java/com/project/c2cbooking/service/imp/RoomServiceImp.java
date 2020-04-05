package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.convert.RoomConvert;
import com.project.c2cbooking.model.RoomEntity;
import com.project.c2cbooking.repository.RoomRepository;
import com.project.c2cbooking.response.RoomResponse;
import com.project.c2cbooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomResponse> topFavoriteRooms(Integer count) {
        List<RoomEntity> roomEntities = roomRepository.findRooms();
        return roomEntities.stream().map(RoomConvert::convert).collect(Collectors.toList());
    }
}
