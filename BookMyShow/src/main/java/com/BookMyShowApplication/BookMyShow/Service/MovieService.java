package com.BookMyShowApplication.BookMyShow.Service;

import com.BookMyShowApplication.BookMyShow.DTO.MovieDto;
import com.BookMyShowApplication.BookMyShow.Entity.Movie;
import com.BookMyShowApplication.BookMyShow.Entity.Show;
import com.BookMyShowApplication.BookMyShow.Entity.Ticket;
import com.BookMyShowApplication.BookMyShow.Repository.MovieRepository;
import com.BookMyShowApplication.BookMyShow.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(MovieDto movieDto) throws Exception{
        Movie movie= MovieTransformer.createDtoToEntity(movieDto);
        movieRepository.save(movie);
        return "Movie has been saved Successfully";
    }

    public String getMaxRevenueMovie() {
        List<Movie> movieList=movieRepository.findAll();
        String movieName="";
        Integer maxRevenue=0;
        for(Movie movie:movieList){
            Integer total=0;
            for(Show show:movie.getShowList()){
                for(Ticket ticket:show.getTicketList()){
                    total+= ticket.getTotalPrice();
                }
            }
            if(total>maxRevenue){
                maxRevenue=total;
                movieName=movie.getMovieName();
            }
        }
        return "Maximum Revenue Movie is : "+movieName+" and the total Revenue is :"+maxRevenue;
    }
}
