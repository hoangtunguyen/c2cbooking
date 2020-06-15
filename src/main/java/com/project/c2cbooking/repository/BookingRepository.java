package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
    List<BookingEntity> getAllByUserEntity_IdAndIsPaidTrueOrderByIdDesc(Integer userId);
    List<BookingEntity> findAllByRoomEntity_UserEntity_IdAndCheckInDate(Integer ownerId, Timestamp checkInDate);
}
