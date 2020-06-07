package com.project.c2cbooking.convert;

import com.project.c2cbooking.model.AmenityEntity;
import com.project.c2cbooking.model.RoomAmenityEntity;
import com.project.c2cbooking.response.AmenityResponse;

public class AmenityConvert {
    public static AmenityResponse convert(RoomAmenityEntity roomAmenityEntity){
        AmenityResponse response = new AmenityResponse();
        response.setId(roomAmenityEntity.getId());
        response.setName(roomAmenityEntity.getAmenityEntity().getName());
        response.setIconUrl(roomAmenityEntity.getAmenityEntity().getIconUrl());
        return response;
    }
}
