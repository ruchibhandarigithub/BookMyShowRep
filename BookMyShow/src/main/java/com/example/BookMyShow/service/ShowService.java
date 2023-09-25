package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.ShowEntryDto;
import com.example.BookMyShow.dto.responseDto.ShowResponseDto;

public interface ShowService {

    public ShowResponseDto addShow(ShowEntryDto showDto);

}