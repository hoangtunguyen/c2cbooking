package com.project.c2cbooking.response;

import lombok.Data;

@Data
public class UserResponse {
    Integer userId;
    String userName;
    String email;
    String urlImage;
}
