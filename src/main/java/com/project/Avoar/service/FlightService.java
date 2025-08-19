package com.project.Avoar.service;

import com.project.Avoar.dto.FlightDTO;
import com.project.Avoar.dto.response.FlightResponseDTO;
import com.project.Avoar.entity.Flight;
import com.project.Avoar.exception.NotFounFlightException;
import com.project.Avoar.mapper.FligthMapper;
import com.project.Avoar.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    private FlightRepository repository;

    public Page<FlightDTO> findAll(int page, int size){
        Page<Flight> flights = repository.findAll(PageRequest.of(page, size));
        return flights.map(f -> new FlightDTO(
                f.getId(),
                f.getDeparturePlace(),
                f.getArrivalPlace(),
                f.getPriceEconomic()));
    }

    public Flight detailsById(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFounFlightException("not found"));
    }
}
