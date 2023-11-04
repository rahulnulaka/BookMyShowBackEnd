package com.BookMyShowApplication.BookMyShow.Transformers;

import com.BookMyShowApplication.BookMyShow.DTO.TheaterDto;
import com.BookMyShowApplication.BookMyShow.Entity.Theater;
import com.BookMyShowApplication.BookMyShow.Entity.TheaterSeats;
import com.BookMyShowApplication.BookMyShow.Enums.SeatType;

import java.util.ArrayList;
import java.util.List;

public class TheaterSeatTransformer {
    public static List<TheaterSeats> createTheaterSeats(TheaterDto theaterDto, Theater theater){

        int noOfPremiumSeats=theaterDto.getNoOfPremiumSeats();
        int noOfClassicSeats= theaterDto.getNoOfClassicSeats();

        int noOfSeatsPerRow= theaterDto.getNoOfSeatsPerRow();

        int row=0;

        char ch='A';
        List<TheaterSeats> theaterSeatsList=new ArrayList<>();
        for(int i=1;i<=noOfPremiumSeats;i++){
            if(i%noOfSeatsPerRow==1){
                row++;
            }
            String seat=row+""+ch;
            ch++;

            TheaterSeats theaterSeats=TheaterSeats.builder()
                    .seatNo(seat)
                    .seatType(SeatType.Premium)
                    .theater(theater)
                    .build();
            theaterSeatsList.add(theaterSeats);
        }
        ch='A';
        for(int i=1;i<=noOfClassicSeats;i++){
            if(i%noOfSeatsPerRow==1){
                row++;
            }
            String seat=row+""+ch;
            ch++;

            TheaterSeats theaterSeats=TheaterSeats.builder()
                    .seatNo(seat)
                    .seatType(SeatType.Classic)
                    .theater(theater)
                    .build();
            theaterSeatsList.add(theaterSeats);
        }
        return theaterSeatsList;
    }
}
