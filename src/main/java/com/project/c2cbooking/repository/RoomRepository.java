package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.ReviewEntity;
import com.project.c2cbooking.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    @Query(value = "SELECT * FROM room u", nativeQuery = true)
    List<RoomEntity> findRooms();
}
