package com.BookMyShowApplication.BookMyShow.Repository;

import com.BookMyShowApplication.BookMyShow.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);
}
