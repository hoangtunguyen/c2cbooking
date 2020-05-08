package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

}
