package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.BookTicketRequestDto;
import com.example.BookMyShow.dto.responseDto.TicketResponseDto;

public interface TicketService {

    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    public TicketResponseDto getTicket(int id);
}