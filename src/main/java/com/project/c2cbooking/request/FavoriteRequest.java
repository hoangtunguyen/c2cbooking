package com.project.c2cbooking.request;

import lombok.Data;

@Data
public class FavoriteRequest {
    String title;
    Integer roomId;
    Integer userId;

}
