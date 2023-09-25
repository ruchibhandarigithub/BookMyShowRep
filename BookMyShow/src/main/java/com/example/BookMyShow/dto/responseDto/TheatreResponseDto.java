package com.example.BookMyShow.dto.responseDto;

import com.example.BookMyShow.enums.TheatreType;
import com.sun.istack.NotNull;
import lombok.*;

@Data
@Builder
public class TheatreResponseDto {

    @NotNull
    int id;

    String name;
    String address;
    String city;
    TheatreType type;
}
