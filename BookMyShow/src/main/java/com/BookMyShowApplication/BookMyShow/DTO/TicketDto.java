package com.BookMyShowApplication.BookMyShow.DTO;

import com.BookMyShowApplication.BookMyShow.Entity.ShowSeats;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketDto {

    String movieName;

    Integer ticketId;

    LocalDate showDate;

    LocalTime showTime;

    Integer userId;

    List<String> requestedSeats;


}
