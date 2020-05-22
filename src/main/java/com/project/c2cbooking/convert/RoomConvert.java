package com.project.c2cbooking.convert;

import com.project.c2cbooking.model.ReviewEntity;
import com.project.c2cbooking.model.RoomEntity;
import com.project.c2cbooking.response.AmenityResponse;
import com.project.c2cbooking.response.RoomFullResponse;
import com.project.c2cbooking.response.RoomResponse;
import com.project.c2cbooking.util.Util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RoomConvert {
    public static final String DEFAULT_RATING = "3";
    public static RoomResponse convert(RoomEntity roomEntity) {
        RoomResponse roomResponse = new RoomResponse();
        roomResponse.setId(roomEntity.getId());
        roomResponse.setName(roomEntity.getName());
        roomResponse.setPrice(new BigDecimal(Util.formatNumber(roomEntity.getPrice().toString())));
        roomResponse.setCategoryRoom(roomEntity.getCategoryEntity().getName());
        roomResponse.setUrlImage(roomEntity.getPhotoEntities().isEmpty() ? null : roomEntity.getPhotoEntities().get(0).getUrl());
        roomResponse.setVotedCount(roomEntity.getReviewEntities().size());
        roomResponse.setRating(roomEntity.getReviewEntities().isEmpty()? DEFAULT_RATING : Util.formatNumber(String.valueOf(avgRating(roomEntity))));
        roomResponse.setCity(roomEntity.getLocationEntity().getCityEntity().getName());
        roomResponse.setLat(Double.parseDouble(roomEntity.getLocationEntity().getLat()));
        roomResponse.setLng(Double.parseDouble(roomEntity.getLocationEntity().getLng()));
        return roomResponse;
    }
    public static RoomFullResponse convertFullData(RoomEntity roomEntity){
        RoomFullResponse roomFullResponse= new RoomFullResponse();
        roomFullResponse.setId(roomEntity.getId());
        roomFullResponse.setName(roomEntity.getName());
        roomFullResponse.setPrice(new BigDecimal(Util.formatNumber(roomEntity.getPrice().toString())));
        roomFullResponse.setCategoryRoom(roomEntity.getCategoryEntity().getName());
        roomFullResponse.setUrlImage(roomEntity.getPhotoEntities().isEmpty() ? null : roomEntity.getPhotoEntities().get(0).getUrl());
        roomFullResponse.setVotedCount(roomEntity.getReviewEntities().size());
        roomFullResponse.setRating(roomEntity.getReviewEntities().isEmpty()? DEFAULT_RATING : Util.formatNumber(String.valueOf(avgRating(roomEntity))));
        roomFullResponse.setAddress(getAddress(roomEntity));
        roomFullResponse.setLat(Double.parseDouble(roomEntity.getLocationEntity().getLat()));
        roomFullResponse.setLng(Double.parseDouble(roomEntity.getLocationEntity().getLng()));
        roomFullResponse.setOwnerName(roomEntity.getUserEntity().getUsername());
        roomFullResponse.setAmenityResponseList(roomEntity.getRoomAmenityEntities().stream().map(AmenityConvert::convert).collect(Collectors.toList()));
        roomFullResponse.setBathroomCount(roomEntity.getBathroomCount());
        roomFullResponse.setGuestCount(roomEntity.getGuestCount());
        roomFullResponse.setBedCount(roomEntity.getBedCount());
        roomFullResponse.setBedroomCount(roomEntity.getBedroomCount());
        roomFullResponse.setMinGuestCount(roomEntity.getMinGuestCount());
        roomFullResponse.setIncreasingPrice(new BigDecimal(Util.formatNumber(roomEntity.getFeeIncreasingPerson().toString())));
        roomFullResponse.setServiceFee(new BigDecimal(Util.formatNumber(roomEntity.getServiceFee().toString())));
        return roomFullResponse;
    }
    public static String getAddress(RoomEntity roomEntity){
        return roomEntity.getLocationEntity().getStreet() + ", "+roomEntity.getLocationEntity().getCityEntity().getName();
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
