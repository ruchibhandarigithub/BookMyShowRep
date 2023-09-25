package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;

public interface TheatreService {


    TheatreResponseDto addTheatre(TheatreEntryDto theaterEntryDto);

    TheatreResponseDto getTheatre(int id);

}