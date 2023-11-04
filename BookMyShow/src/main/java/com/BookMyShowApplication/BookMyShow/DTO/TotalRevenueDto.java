package com.BookMyShowApplication.BookMyShow.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.FetchProfile;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TotalRevenueDto {
    Integer theaterId;

    LocalDate date;
}
