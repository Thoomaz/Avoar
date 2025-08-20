package com.project.Avoar.mapper;

import com.project.Avoar.dto.TicketDTO;
import com.project.Avoar.entity.Ticket;

import java.util.List;

public class TicketMapper {
    public static TicketDTO toDTO(Ticket obj){
        String departurePlace = obj.getFlights().get(0).getDeparturePlace();
        String arrivalPlace = obj.getFlights().get(0).getArrivalPlace();
        return new TicketDTO(obj.getId(),
                obj.getSeat(), obj.getClassAirplane(), departurePlace, arrivalPlace, obj.getTicketValue(), obj.getPayment().getStatus());
    }

    public static List<TicketDTO> toDTOList(List<Ticket> objList){
        return objList.stream()
                .map(TicketMapper::toDTO)
                .toList();
    }
}
