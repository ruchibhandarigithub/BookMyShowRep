package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.ShowEntryDto;
import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.model.Show;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {


    public static Show convertDtoToEntity(ShowEntryDto showDto) {

        return Show.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(Show showEntity, ShowEntryDto showEntryDto) {

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theatreDto(showEntryDto.getTheatreResponseDto())
                .build();
    }
}