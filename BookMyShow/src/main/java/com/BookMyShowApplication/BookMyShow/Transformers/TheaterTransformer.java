package com.BookMyShowApplication.BookMyShow.Transformers;

import com.BookMyShowApplication.BookMyShow.DTO.TheaterDto;
import com.BookMyShowApplication.BookMyShow.Entity.Theater;
import com.BookMyShowApplication.BookMyShow.Entity.TheaterSeats;
import com.BookMyShowApplication.BookMyShow.Enums.City;

import java.util.List;

public class TheaterTransformer {

    public static Theater createTheater(TheaterDto theaterDto){
        Theater theater= Theater.builder()
                .name(theaterDto.getName())
                .address(theaterDto.getAddress())
                .city(City.valueOf(theaterDto.getCity()))
                .build();
        return theater;
    }
}
