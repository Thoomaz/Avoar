package com.project.Avoar.repository;

import com.project.Avoar.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
