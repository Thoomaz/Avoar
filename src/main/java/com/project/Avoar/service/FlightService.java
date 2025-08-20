package com.project.Avoar.service;

import com.project.Avoar.dto.FlightDTO;
import com.project.Avoar.entity.Flight;
import com.project.Avoar.exception.NotFoundFlightException;
import com.project.Avoar.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return repository.findById(id).orElseThrow(() -> new NotFoundFlightException("not found"));
    }
}
