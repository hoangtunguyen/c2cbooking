package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
}
