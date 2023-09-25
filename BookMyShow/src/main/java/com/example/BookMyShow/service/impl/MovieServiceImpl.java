package com.example.BookMyShow.service.impl;


import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto)  {


        MovieResponseDto movieResponseDto = new MovieResponseDto();

        //if the movie is already created then we can throw an exception....movie already exists.
        if(movieRepository.existsByName(movieEntryDto.getName())){
            movieResponseDto.setName("This movie is already Existing");
            return movieResponseDto;
        }


        Movie movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);


        movieEntity = movieRepository.save(movieEntity); //This will auto add the id variable

        movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto; //It can be a response type of the movie

    }

    @Override
    public MovieResponseDto getMovie(int id) {

        Movie movieEntity = movieRepository.findById(id).get();

        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;

    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id){

        //I need information from repo
        Movie movieEntity = movieRepository.findById(id).get(); //Get this movieEntity from the database


        //I have to convert it

        MovieNameAndIdObject obj = MovieConverter.convertEntityToThisObject(movieEntity);


        return obj;
    }

}