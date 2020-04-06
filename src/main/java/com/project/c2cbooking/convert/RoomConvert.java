package com.project.c2cbooking.convert;

import com.project.c2cbooking.model.ReviewEntity;
import com.project.c2cbooking.model.RoomEntity;
import com.project.c2cbooking.response.RoomFullResponse;
import com.project.c2cbooking.response.RoomResponse;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.function.Function;

public class RoomConvert {
    public static RoomResponse convert(RoomEntity roomEntity) {
        RoomResponse roomResponse = new RoomResponse();
        roomResponse.setId(roomEntity.getId());
        roomResponse.setName(roomEntity.getName());
        roomResponse.setPrice(roomEntity.getPrice().toString());
        roomResponse.setTypeRoom(roomEntity.getRoomTypeEntity().getName());
        roomResponse.setUrlImage(roomEntity.getPhotoEntities().isEmpty() ? null : roomEntity.getPhotoEntities().get(0).getUrl());
        roomResponse.setVotedCount(String.valueOf(roomEntity.getReviewEntities().size()));
        roomResponse.setRating(roomEntity.getReviewEntities().isEmpty()? null : String.valueOf(avgRating(roomEntity)));

        return roomResponse;
    }
    public static RoomFullResponse convertFullData(RoomEntity roomEntity){
        RoomFullResponse roomFullResponse= new RoomFullResponse();
        roomFullResponse.setId(roomEntity.getId());
        roomFullResponse.setName(roomEntity.getName());
        roomFullResponse.setPrice(roomEntity.getPrice().toString());
        roomFullResponse.setTypeRoom(roomEntity.getRoomTypeEntity().getName());
        roomFullResponse.setUrlImage(roomEntity.getPhotoEntities().isEmpty() ? null : roomEntity.getPhotoEntities().get(0).getUrl());
        roomFullResponse.setVotedCount(String.valueOf(roomEntity.getReviewEntities().size()));
        roomFullResponse.setRating(roomEntity.getReviewEntities().isEmpty()? null : String.valueOf(avgRating(roomEntity)));
        roomFullResponse.setAddress(getAddress(roomEntity));
        roomFullResponse.setLat(roomEntity.getLocationEntity().getLat());
        roomFullResponse.setLng(roomEntity.getLocationEntity().getLng());
        roomFullResponse.setOwnerName(roomEntity.getUserEntity().getUsername());
        return roomFullResponse;
    }
    public static String getAddress(RoomEntity roomEntity){
        return roomEntity.getLocationEntity().getStreet() + " "+roomEntity.getLocationEntity().getCityEntity().getName();
    }
    public static double avgRating(RoomEntity roomEntities) {
        int sum = 0;
        for (ReviewEntity reviewEntity : roomEntities.getReviewEntities()) {
            sum += reviewEntity.getRating();
        }
        double avg = (double) sum/roomEntities.getReviewEntities().size();
        avg =Math.round(avg *100.00)/100.00;
        return avg;
    }
}
