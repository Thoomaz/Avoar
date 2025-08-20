package com.project.Avoar.dto.request;

import com.project.Avoar.entity.enumns.PaymentStatus;

public record PaymentRequestDTO(Double value, String paymentMethod) {
}
