package com.project.Avoar.mapper;

import com.project.Avoar.dto.response.PaymentResponseDTO;
import com.project.Avoar.dto.request.PaymentRequestDTO;
import com.project.Avoar.entity.Payment;

public class PaymentMapper {
    public static Payment toEntity(PaymentRequestDTO dto){
        Payment payment = new Payment();
        payment.setValuePayment(dto.value());
        payment.setPaymentMethod(dto.paymentMethod());
        return payment;
    }

    public static PaymentResponseDTO toDTO(Payment obj){
        return new PaymentResponseDTO(obj.getValuePayment(), obj.getStatus(), obj.getDate());
    }
}
