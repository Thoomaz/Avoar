package com.project.Avoar.controller;

import com.project.Avoar.dto.request.PaymentRequestDTO;
import com.project.Avoar.dto.response.PaymentResponseDTO;
import com.project.Avoar.entity.Payment;
import com.project.Avoar.mapper.PaymentMapper;
import com.project.Avoar.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment/{userId}")
@Tag(name = "Payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping
    @Operation(
            summary = "Make a payment for a user",
            tags = {"Payment"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PaymentResponseDTO.class)
                    )),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<PaymentResponseDTO> makePayment(@PathVariable Long userId, @RequestBody PaymentRequestDTO dto){
        Payment payment = PaymentMapper.toEntity(dto);
        PaymentResponseDTO dtoResponse = PaymentMapper.toDTO(service.makePayment(payment, userId));
        return ResponseEntity.ok().body(dtoResponse);
    }
}