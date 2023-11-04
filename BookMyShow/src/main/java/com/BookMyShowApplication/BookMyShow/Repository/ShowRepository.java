package com.BookMyShowApplication.BookMyShow.Repository;

import com.BookMyShowApplication.BookMyShow.Entity.Movie;
import com.BookMyShowApplication.BookMyShow.Entity.Show;
import com.BookMyShowApplication.BookMyShow.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Integer> {

    Show findShowByMovieAndTheaterAndShowDateAndShowTime(Movie movie, Theater theater, LocalDate showDate, LocalTime showTime);
    List<Show> findShowsByTheaterAndShowDate(Theater theater,LocalDate showDate);
}
