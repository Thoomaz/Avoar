package com.project.Avoar.controller;

import com.project.Avoar.dto.TicketDTO;
import com.project.Avoar.entity.Ticket;
import com.project.Avoar.entity.enumns.ClassAirplane;
import com.project.Avoar.mapper.TicketMapper;
import com.project.Avoar.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket/{userId}")
@Tag(name = "Ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping
    @Operation(
            summary = "Find all tickets for a specific user",
            tags = {"Ticket"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = TicketDTO.class))
                    )),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<List<TicketDTO>> findAll(@PathVariable Long userId){
        List<TicketDTO> dtos = TicketMapper.toDTOList(service.findAllByUser(userId));
        return ResponseEntity.ok(dtos);
    }

    @Transactional
    @PostMapping(value = "/{flightId}")
    @Operation(
            summary = "Book one or more tickets for a flight",
            tags = {"Ticket"},
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201", content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = TicketDTO.class))
                    )),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<List<TicketDTO>> book(@PathVariable Long userId,
                                                @PathVariable Long flightId,
                                                @RequestParam int economic,
                                                @RequestParam(required = false) Integer executive,
                                                @RequestParam(required = false) Integer firstClass){
        List<Ticket> tickets = service.book(
                userId,
                flightId,
                economic,
                executive != null ? executive : 0,
                firstClass != null ? firstClass : 0
        );
        List<TicketDTO> dtos = TicketMapper.toDTOList(tickets);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtos);
    }
}