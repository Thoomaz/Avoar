package com.project.Avoar.dto.response;

import com.project.Avoar.entity.enumns.PaymentStatus;

import java.time.LocalDate;

public record PaymentResponseDTO(Double value, PaymentStatus paymentStatus, LocalDate date) {
}
