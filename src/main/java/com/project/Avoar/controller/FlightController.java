package com.project.Avoar.controller;

import com.project.Avoar.dto.FlightDTO;
import com.project.Avoar.dto.response.FlightResponseDTO;
import com.project.Avoar.entity.Flight;
import com.project.Avoar.mapper.FligthMapper;
import com.project.Avoar.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/flights")
@Tag(name = "Flight")
public class FlightController {
    @Autowired
    private FlightService service;

    @GetMapping
    @Operation(
            summary = "List all flights with pagination",
            tags = {"Flight"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FlightDTO.class))
                    )),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Page<FlightDTO>> listAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(service.findAll(page, size));
    }

    @GetMapping(value = "/{flightId}")
    @Operation(
            summary = "Find a flight by its ID",
            tags = {"Flight"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = FlightResponseDTO.class)
                    )),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<FlightResponseDTO> findById(@PathVariable Long flightId){
        FlightResponseDTO dto = FligthMapper.toResponseDTO(service.detailsById(flightId));
        return ResponseEntity.ok(dto);
    }
}