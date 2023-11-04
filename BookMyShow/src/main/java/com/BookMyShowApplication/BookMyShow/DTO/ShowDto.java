package com.BookMyShowApplication.BookMyShow.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowDto {

    LocalDate showDate;

    LocalTime showTime;

    String movieName;

    Integer theaterId;

}
