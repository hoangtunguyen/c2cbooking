package com.project.c2cbooking.service;

import com.project.c2cbooking.request.AddRoomRequest;
import com.project.c2cbooking.request.RoomRequest;
import com.project.c2cbooking.response.HostListingResponse;
import com.project.c2cbooking.response.RoomFullResponse;
import com.project.c2cbooking.response.RoomResponse;

import java.util.List;

public interface RoomService {
    List<RoomResponse> topFavoriteRooms(Integer count);
    RoomFullResponse findOneRoom(Integer idRoom);
    List<RoomResponse> viewAllRooms();
    List<RoomResponse> searchRoom(RoomRequest roomRequest);
    void addRoom(AddRoomRequest request);


    List<HostListingResponse> getListRoomsByUserId(Integer id);
}
