package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.FavoriteRoomEntity;
import com.project.c2cbooking.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
