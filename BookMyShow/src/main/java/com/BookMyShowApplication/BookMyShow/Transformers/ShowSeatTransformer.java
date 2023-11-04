package com.BookMyShowApplication.BookMyShow.Transformers;

import com.BookMyShowApplication.BookMyShow.DTO.ShowSeatDto;
import com.BookMyShowApplication.BookMyShow.Entity.Show;
import com.BookMyShowApplication.BookMyShow.Entity.ShowSeats;
import com.BookMyShowApplication.BookMyShow.Entity.TheaterSeats;
import com.BookMyShowApplication.BookMyShow.Enums.SeatType;

public class ShowSeatTransformer {
    public static  ShowSeats createDtoIntoentity(TheaterSeats theaterSeats, Show show, ShowSeatDto showSeatDto){
        ShowSeats showSeat=ShowSeats.builder()
                .seatNo(theaterSeats.getSeatNo())
                .seatType(theaterSeats.getSeatType())
                .isAvailable(true)
                .isFoodAttached(false)
                .show(show)
                .build();

        if(theaterSeats.getSeatType().equals(SeatType.Classic)){
            showSeat.setCost(showSeatDto.getCostOfClassicSeats());
        }
        else showSeat.setCost(showSeatDto.getCostOfPremiumSeats());
       return showSeat;
    }
}
