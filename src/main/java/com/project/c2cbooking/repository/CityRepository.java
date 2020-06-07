package com.project.c2cbooking.repository;

import com.project.c2cbooking.model.location.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
}
