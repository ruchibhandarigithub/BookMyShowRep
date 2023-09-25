package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.model.Movie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {


    public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){

        return Movie.builder() //.attribute (value)
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate()).build();

    }


    public static MovieResponseDto convertEntityToDto(Movie movieEntity){

        return MovieResponseDto.builder().id(movieEntity.getId()).releaseDate(movieEntity.getReleaseDate()).name(movieEntity.getName()).build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(Movie movieEntity){


        return MovieNameAndIdObject.builder().
                id(movieEntity.getId())
                .name(movieEntity.getName()).build();

    }
}