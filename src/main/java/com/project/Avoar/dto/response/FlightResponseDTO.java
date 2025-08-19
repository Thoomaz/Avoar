package com.project.Avoar.dto.response;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record FlightResponseDTO(
        Long id,
        LocalDate departureDate,
        LocalDate arrivalDate,
        String departurePlace,
        String arrivalPlace,
        Double priceEconomic,
        Double priceExecutive,
        Double priceFirstClass
        ) {
}
