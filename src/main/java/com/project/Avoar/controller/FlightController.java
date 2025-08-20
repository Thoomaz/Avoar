package com.project.Avoar.controller;

import com.project.Avoar.dto.FlightDTO;
import com.project.Avoar.dto.response.FlightResponseDTO;
import com.project.Avoar.entity.Flight;
import com.project.Avoar.mapper.FligthMapper;
import com.project.Avoar.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {
    @Autowired
    private FlightService service;

    @GetMapping
    public ResponseEntity<Page<FlightDTO>> listAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(service.findAll(page, size));
    }

    @GetMapping(value = "/{flightId}")
    public ResponseEntity<FlightResponseDTO> findById(@PathVariable Long flightId){
        FlightResponseDTO dto = FligthMapper.toResponseDTO(service.detailsById(flightId));
        return ResponseEntity.ok(dto);
    }
}
