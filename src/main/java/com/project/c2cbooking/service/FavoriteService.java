package com.project.c2cbooking.service;

import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.request.FavoriteRequest;
import com.project.c2cbooking.response.FavoriteResponse;

import java.util.List;

public interface FavoriteService {
    void addFavorite(FavoriteRequest favoriteRequest);
    List<FavoriteResponse> getFavoriteList(Integer userId);
}
