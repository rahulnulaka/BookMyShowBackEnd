package com.BookMyShowApplication.BookMyShow.DTO;

import com.BookMyShowApplication.BookMyShow.Enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class MovieDto {
    String movieName;

    double rating;
    Genre genre;

    LocalDate releasedDate;
}
