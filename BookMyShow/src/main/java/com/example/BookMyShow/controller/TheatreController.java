package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.BookMyShow.service.impl.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;


    @PostMapping("/add")
    public TheatreResponseDto addTheatre(@RequestBody() TheatreEntryDto theaterEntryDto){

        return theatreService.addTheatre(theaterEntryDto);

    }

}