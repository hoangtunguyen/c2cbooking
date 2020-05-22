package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<FavoriteRoomEntity, Integer> {
    List<FavoriteRoomEntity> findAllByUserEntity_IdOrderByIdDesc(Integer userId);
    Boolean existsFavoriteRoomEntityByUserEntity_IdAndRoomEntity_Id(Integer userId, Integer roomId);
    FavoriteRoomEntity findByUserEntity_IdAndRoomEntity_Id(Integer userId, Integer roomId);
}
