package com.project.Avoar.dto;

import com.project.Avoar.entity.Ticket;
import com.project.Avoar.entity.enumns.ClassAirplane;
import com.project.Avoar.entity.enumns.PaymentStatus;

public record TicketDTO(
        Long id,
        String seat,
        ClassAirplane classAirplane,
        String departurePlace,
        String arrivalPlace,
        Double ticketValue,
        PaymentStatus paymentStatus
    ) {

}
