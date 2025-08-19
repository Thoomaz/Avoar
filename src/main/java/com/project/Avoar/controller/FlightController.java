package com.project.Avoar.controller;

import com.project.Avoar.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {
    @Autowired
    private FlightService service;

    @GetMapping
    public Respo
}
