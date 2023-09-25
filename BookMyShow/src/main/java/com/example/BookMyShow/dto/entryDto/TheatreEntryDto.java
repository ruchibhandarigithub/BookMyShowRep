package com.example.BookMyShow.dto.entryDto;

import com.example.BookMyShow.enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntryDto {

    String name;
    String address;
    String city;
    TheatreType type;

}