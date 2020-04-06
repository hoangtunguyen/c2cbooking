package com.project.c2cbooking.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AmenityResponse {
    String name;
    String iconUrl;
}
