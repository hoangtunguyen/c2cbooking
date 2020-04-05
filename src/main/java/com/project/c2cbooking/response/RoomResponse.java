package com.project.c2cbooking.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomResponse {
    Integer id;
    String name;
    String typeRoom;
    String votedCount;
    String rating;
    String price;
    String urlImage;

}
