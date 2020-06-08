package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer> {
}
