package com.example.BookMyShow.dto.responseDto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponseDto {


    int id;

    LocalDate showDate;

    LocalTime showTime;

    MovieResponseDto movieResponseDto;

    TheatreResponseDto theatreDto;

}
