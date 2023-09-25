package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.BookMyShow.model.Theatre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static Theatre convertDtoToEntity(TheatreEntryDto theaterEntryDto){

        return Theatre.builder().address(theaterEntryDto.getAddress())
                .city(theaterEntryDto.getCity()).name(theaterEntryDto.getName()).type(theaterEntryDto.getType()).build();


    }

    public static TheatreResponseDto convertEntityToDto(Theatre theaterEntity){

        return TheatreResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress())
                .type(theaterEntity.getType())
                .build();
    }
}