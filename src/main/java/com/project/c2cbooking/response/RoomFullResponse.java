package com.project.c2cbooking.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomFullResponse {
    Integer id;
    String name;
    String typeRoom;
    String votedCount;
    String rating;
    String price;
    String urlImage;
    String address;
    String lat;
    String lng;
    RoomDetailResponse roomDetailResponse;
    String ownerName;
    List<AmenityResponse> amenityResponseList;
}
