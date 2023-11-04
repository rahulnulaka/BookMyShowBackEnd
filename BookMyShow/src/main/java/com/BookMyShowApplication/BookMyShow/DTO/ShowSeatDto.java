package com.BookMyShowApplication.BookMyShow.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowSeatDto {

    Integer showId;

    Integer costOfClassicSeats;

    Integer costOfPremiumSeats;
}
