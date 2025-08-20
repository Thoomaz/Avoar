package com.project.Avoar.mapper;

import com.project.Avoar.dto.FlightDTO;
import com.project.Avoar.dto.response.FlightResponseDTO;
import com.project.Avoar.entity.Flight;

public class FligthMapper {
    public static FlightDTO toDTO(Flight obj){
        return new FlightDTO(obj.getId(), obj.getDeparturePlace(), obj.getArrivalPlace(), obj.getPriceEconomic());
    }

    public static FlightResponseDTO toResponseDTO(Flight obj){
        return new FlightResponseDTO(
                obj.getId(),
                obj.getDepartureDate(),
                obj.getArrivalDate(),
                obj.getDeparturePlace(),
                obj.getArrivalPlace(),
                obj.getPriceEconomic(),
                obj.getPriceExecutive(),
                obj.getPriceFirstClass()
        );
    }
}
