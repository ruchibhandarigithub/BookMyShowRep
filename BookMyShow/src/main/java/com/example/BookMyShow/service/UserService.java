package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.UserEntryDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;

public interface UserService {

    //add
    public void addUser(UserEntryDto userDto);

    //get
    public UserResponseDto getUser(int id);
}