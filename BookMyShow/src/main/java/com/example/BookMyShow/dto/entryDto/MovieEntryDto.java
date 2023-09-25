package com.example.BookMyShow.dto.entryDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class MovieEntryDto { //Dtos are built to avoid heavy api calling bcz they contain only required parameters

    String name;

    @NotNull
    LocalDate releaseDate;
}