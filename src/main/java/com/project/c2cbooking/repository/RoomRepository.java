package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.ReviewEntity;
import com.project.c2cbooking.model.RoomEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query(value = "SELECT * FROM c2cbooking135_db.review r RIGHT join c2cbooking135_db.room ro ON ro.room_id = r.room_id group by r.room_id order by avg(r.rating) desc limit :topQuantity", nativeQuery = true)
    List<RoomEntity> findTopFavoritesLimit(@Param("topQuantity") Integer quantity);

    RoomEntity findByIdEquals(Integer id);
}
