package com.example.BookMyShow.dto.entryDto;

import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;

    ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto; //Mandatory for me to fill this userDto Value
}