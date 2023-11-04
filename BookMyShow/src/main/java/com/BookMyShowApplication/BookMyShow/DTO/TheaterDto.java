package com.BookMyShowApplication.BookMyShow.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TheaterDto {

    String name;

    String address;

    String city;

    Integer noOfPremiumSeats;

    Integer noOfClassicSeats;

    Integer noOfSeatsPerRow;
}
