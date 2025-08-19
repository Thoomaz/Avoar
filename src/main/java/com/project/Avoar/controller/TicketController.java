package com.project.Avoar.controller;

import com.project.Avoar.dto.TicketDTO;
import com.project.Avoar.entity.Ticket;
import com.project.Avoar.entity.enumns.ClassAirplane;
import com.project.Avoar.mapper.TicketMapper;
import com.project.Avoar.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket/{userId}")
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping
    public ResponseEntity<List<TicketDTO>> findAll(@PathVariable Long userId){

    }

    @PostMapping(value = "/{flightId}")
    public ResponseEntity<List<TicketDTO>> book(@PathVariable Long userId,
                                                @PathVariable Long flightId,
                                                @RequestParam int economic,
                                                @RequestParam(required = false) int executive,
                                                @RequestParam(required = false) int firstClass){
        List<Ticket> tickets = service.book(userId, flightId, economic, executive, firstClass);
        List<TicketDTO> dtos = TicketMapper.toDTOList(tickets);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtos);
    }
}
