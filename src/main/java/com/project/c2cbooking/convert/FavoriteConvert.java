package com.project.c2cbooking.convert;

import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.response.FavoriteResponse;

public class FavoriteConvert {
    public static FavoriteResponse convert(FavoriteRoomEntity favoriteRoomEntity){
        FavoriteResponse response = new FavoriteResponse();
        response.setId(favoriteRoomEntity.getId());
        response.setTitle(favoriteRoomEntity.getTitle());
        response.setRoomResponse(RoomConvert.convert(favoriteRoomEntity.getRoomEntity()));
        return response;
    }
}
