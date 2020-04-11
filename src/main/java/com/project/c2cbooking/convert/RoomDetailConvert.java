package com.project.c2cbooking.convert;

import com.project.c2cbooking.model.RoomDetailEntity;
import com.project.c2cbooking.response.RoomDetailResponse;

public class RoomDetailConvert {
    public static RoomDetailResponse convert(RoomDetailEntity roomDetailEntity){
        RoomDetailResponse response = new RoomDetailResponse();
        response.setId(roomDetailEntity.getId());
        response.setBathroomCount(roomDetailEntity.getBathroomCount());
        response.setBedCount(roomDetailEntity.getBedCount());
        response.setBedroomCount(roomDetailEntity.getBedroomCount());
        response.setGuestCount(roomDetailEntity.getGuestCount());
        return response;
    }
}
