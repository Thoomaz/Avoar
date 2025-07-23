package com.project.Avoar.repositories;

import com.project.Avoar.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
