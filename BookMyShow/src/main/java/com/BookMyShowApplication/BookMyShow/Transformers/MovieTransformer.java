package com.BookMyShowApplication.BookMyShow.Transformers;

import com.BookMyShowApplication.BookMyShow.DTO.MovieDto;
import com.BookMyShowApplication.BookMyShow.Entity.Movie;

public class MovieTransformer {
    public static Movie createDtoToEntity(MovieDto movieDto){
        return Movie.builder().movieName(movieDto.getMovieName())
                .genre(movieDto.getGenre())
                .rating(movieDto.getRating())
                .releasedDate(movieDto.getReleasedDate())
                .build();
    }
}
