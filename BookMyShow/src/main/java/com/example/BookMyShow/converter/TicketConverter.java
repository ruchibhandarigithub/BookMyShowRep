package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.responseDto.TicketResponseDto;
import com.example.BookMyShow.model.Ticket;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {

    public static TicketResponseDto convertEntityToDto(Ticket ticketEntity){

        return TicketResponseDto.builder().id((int) ticketEntity.getId()).amount(ticketEntity.getAmount())
                .alloted_seats(ticketEntity.getAllottedSeats())
                .build();

    }
}