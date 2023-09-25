package com.example.BookMyShow.dto.entryDto;

import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheatreResponseDto theatreResponseDto;
}