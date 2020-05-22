package com.project.c2cbooking.service.imp;

import com.project.c2cbooking.convert.FavoriteConvert;
import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.repository.FavoriteRepository;
import com.project.c2cbooking.repository.RoomRepository;
import com.project.c2cbooking.repository.UserRepository;
import com.project.c2cbooking.request.FavoriteRequest;
import com.project.c2cbooking.response.FavoriteResponse;
import com.project.c2cbooking.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImp implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void addFavorite(FavoriteRequest favoriteRequest) {
        FavoriteRoomEntity favorite = new FavoriteRoomEntity();
        favorite.setTitle(favoriteRequest.getTitle());
        favorite.setRoomEntity(roomRepository.findById(favoriteRequest.getRoomId()).get());
        favorite.setUserEntity(userRepository.findById(favoriteRequest.getUserId()).get());
        favorite.setDelFlag(false);
        favoriteRepository.save(favorite);
    }

    @Override
    public List<FavoriteResponse> getFavoriteList(Integer userId) {
        List<FavoriteRoomEntity> list = favoriteRepository.findAllByUserEntity_IdOrderByIdDesc(userId);
        return list.stream().map(FavoriteConvert::convert).collect(Collectors.toList());
    }

    @Override
    public Boolean isExist(Integer userId, Integer roomId) {
        return favoriteRepository.existsFavoriteRoomEntityByUserEntity_IdAndRoomEntity_Id(userId, roomId);
    }

    @Override
    public void deleteFavorite(Integer userId, Integer roomId) {
        FavoriteRoomEntity favorite = favoriteRepository.findByUserEntity_IdAndRoomEntity_Id(userId, roomId);
        favoriteRepository.delete(favorite);
    }


}
