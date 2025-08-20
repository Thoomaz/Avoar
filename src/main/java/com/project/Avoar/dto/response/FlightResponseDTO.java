package com.project.Avoar.dto.response;

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
