package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.ReviewEntity;
import com.project.c2cbooking.model.RoomEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query(value = "SELECT * FROM c2cbooking135_db.review r RIGHT join c2cbooking135_db.room ro ON ro.room_id = r.room_id group by r.room_id order by avg(r.rating) desc limit :topQuantity", nativeQuery = true)
    List<RoomEntity> findTopFavoritesLimit(@Param("topQuantity") Integer quantity);

    RoomEntity findByIdEquals(Integer id);


    @Query(value = "SELECT ro FROM RoomEntity ro " +
            "inner join ro.locationEntity lo " +
            "inner join ro.locationEntity.cityEntity lo_ci " +
            "where ro.guestCount <= ?1 and (ro.price between  ?2  and  ?3) and (lo.street like %?4% or lo_ci.name like %?4%) and ro.name like %?5% and ro.categoryEntity.roomTypeEntity.id in ?6")
    List<RoomEntity> searchRoom(Integer guestCount, BigDecimal minPrice, BigDecimal maxPrice, String location, String name, Collection<Integer> roomTypeId);
}
