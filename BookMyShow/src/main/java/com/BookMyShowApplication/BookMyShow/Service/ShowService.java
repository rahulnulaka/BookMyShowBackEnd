package com.BookMyShowApplication.BookMyShow.Service;

import com.BookMyShowApplication.BookMyShow.DTO.ShowDto;
import com.BookMyShowApplication.BookMyShow.DTO.ShowSeatDto;
import com.BookMyShowApplication.BookMyShow.Entity.*;
import com.BookMyShowApplication.BookMyShow.Enums.SeatType;
import com.BookMyShowApplication.BookMyShow.Exceptions.MovieNotFoundException;
import com.BookMyShowApplication.BookMyShow.Exceptions.ShowNotFoundException;
import com.BookMyShowApplication.BookMyShow.Exceptions.TheaterNotFoundException;
import com.BookMyShowApplication.BookMyShow.Repository.MovieRepository;
import com.BookMyShowApplication.BookMyShow.Repository.ShowRepository;
import com.BookMyShowApplication.BookMyShow.Repository.ShowSeatsRepository;
import com.BookMyShowApplication.BookMyShow.Repository.TheaterRepository;
import com.BookMyShowApplication.BookMyShow.Transformers.ShowSeatTransformer;
import com.BookMyShowApplication.BookMyShow.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowSeatsRepository showSeatsRepository;


    public String addShow(ShowDto showDto) throws Exception{
        Movie movie=movieRepository.findMovieByMovieName(showDto.getMovieName());
        if(movie==null){
            throw new MovieNotFoundException("moviename not found in the db");
        }
        Show show= ShowTransformer.createDtoToEntity(showDto);

        Optional<Theater> optionalTheater=theaterRepository.findById(showDto.getTheaterId());

        if(optionalTheater.isEmpty()){
            throw new TheaterNotFoundException("theater not found in the Db");
        }
        Theater theater=optionalTheater.get();

        show.setMovie(movie);
        show.setTheater(theater);

        movie.getShowList().add(show);
        theater.getShowList().add(show);

        showRepository.save(show);

        return "show has been successfully saved to the db";
    }

    public String showSeats(ShowSeatDto showSeatDto)throws Exception {

        Optional<Show> optionalShow=showRepository.findById(showSeatDto.getShowId());
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("show not found with :"+showSeatDto.getShowId());
        }
        Show show=optionalShow.get();
        Theater theater=show.getTheater();
        List<TheaterSeats> theaterSeatsList=theater.getTheaterSeatsList();

        List<ShowSeats> showSeatsList=new ArrayList<>();
        for(TheaterSeats theaterSeats:theaterSeatsList){
            ShowSeats showSeat= ShowSeatTransformer.createDtoIntoentity(theaterSeats,show,showSeatDto);
            showSeatsList.add(showSeat);
        }
        show.setShowSeatsList(showSeatsList);
        //showSeatsRepository.saveAll(showSeatsList);
        showRepository.save(show);
        return "showSeats has been successfully executed";
    }
}
