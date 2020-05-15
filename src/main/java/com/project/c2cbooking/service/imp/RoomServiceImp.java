package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.convert.AmenityConvert;
import com.project.c2cbooking.convert.RoomConvert;
import com.project.c2cbooking.model.AmenityEntity;
import com.project.c2cbooking.model.RoomEntity;
import com.project.c2cbooking.repository.RoomRepository;
import com.project.c2cbooking.request.RoomRequest;
import com.project.c2cbooking.response.AmenityResponse;
import com.project.c2cbooking.response.RoomFullResponse;
import com.project.c2cbooking.response.RoomResponse;
import com.project.c2cbooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomResponse> topFavoriteRooms(Integer count) {
        List<RoomEntity> roomEntities = roomRepository.findTopFavoritesLimit(count);
        return roomEntities.stream().map(RoomConvert::convert).collect(Collectors.toList());
    }

    @Override
    public RoomFullResponse findOneRoom(Integer idRoom) {
        RoomEntity roomEntity = roomRepository.findByIdEquals(idRoom);
        return RoomConvert.convertFullData(roomEntity);
    }

    @Override
    public List<RoomResponse> viewAllRooms() {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        return roomEntities.stream().map(RoomConvert::convert).collect(Collectors.toList());
    }

    @Override
    public List<RoomResponse> searchRoom(RoomRequest roomRequest) {

        roomRequest.setMaxPrice(roomRequest.getMaxPrice() == null ? Integer.MAX_VALUE : roomRequest.getMaxPrice());
        roomRequest.setMinPrice(roomRequest.getMinPrice() == null ? 0 : roomRequest.getMinPrice());
        List<RoomEntity> roomEntities = roomRepository.searchRoom(
                roomRequest.getGuestCount(),
                new BigDecimal(roomRequest.getMinPrice()),
                new BigDecimal(roomRequest.getMaxPrice()),
                roomRequest.getLocation());
        return roomEntities.stream().map(RoomConvert::convert).collect(Collectors.toList());
    }
}
