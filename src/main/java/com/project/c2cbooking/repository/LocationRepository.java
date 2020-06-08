package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.model.location.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
}
