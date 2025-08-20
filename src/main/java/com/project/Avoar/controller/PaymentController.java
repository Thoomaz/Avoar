package com.project.Avoar.controller;

import com.project.Avoar.dto.request.PaymentRequestDTO;
import com.project.Avoar.dto.response.PaymentResponseDTO;
import com.project.Avoar.entity.Payment;
import com.project.Avoar.mapper.PaymentMapper;
import com.project.Avoar.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment/{userId}")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment(@PathVariable Long userId, @RequestBody PaymentRequestDTO dto){
        Payment payment = PaymentMapper.toEntity(dto);
        PaymentResponseDTO dtoResponse = PaymentMapper.toDTO(service.makePayment(payment, userId));
        return ResponseEntity.ok().body(dtoResponse);
    }
}
