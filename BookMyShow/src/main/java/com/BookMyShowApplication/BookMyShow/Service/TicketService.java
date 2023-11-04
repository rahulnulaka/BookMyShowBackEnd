package com.BookMyShowApplication.BookMyShow.Service;

import com.BookMyShowApplication.BookMyShow.DTO.TicketDto;
import com.BookMyShowApplication.BookMyShow.Entity.*;
import com.BookMyShowApplication.BookMyShow.Exceptions.ShowNotFoundException;
import com.BookMyShowApplication.BookMyShow.Exceptions.TheaterNotFoundException;
import com.BookMyShowApplication.BookMyShow.Exceptions.UserNotFoundException;
import com.BookMyShowApplication.BookMyShow.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRespository ticketRespository;

    public String bookTicket(TicketDto ticketDto)throws Exception {
        Movie movie=movieRepository.findMovieByMovieName(ticketDto.getMovieName());

        Optional<Theater> optionalTheater =theaterRepository.findById(ticketDto.getTicketId());

        if(optionalTheater.isEmpty()){
            throw new TheaterNotFoundException("The theater you are looking for is not present in the DB");
        }

        Theater theater=optionalTheater.get();

        Show show=showRepository.findShowByMovieAndTheaterAndShowDateAndShowTime(movie,theater,ticketDto.getShowDate(),ticketDto.getShowTime());
        if(show==null){
            throw new ShowNotFoundException("show not found");
        }
        Integer totalPrice=0;
        List<ShowSeats> showSeatsListshow=show.getShowSeatsList();
        for(ShowSeats showSeats:showSeatsListshow){
            if(ticketDto.getRequestedSeats().contains(showSeats.getSeatNo())){
                showSeats.setAvailable(false);
                totalPrice+=showSeats.getCost();
            }
        }
        Optional<User> optionalUser=userRepository.findById(ticketDto.getUserId());
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("Invalid user found");
        }
        User user=optionalUser.get();
        Ticket ticket=Ticket.builder()
                .movieName(ticketDto.getMovieName())
                .show(show)
                .user(user)
                .showDate(ticketDto.getShowDate())
                .showTime(ticketDto.getShowTime())
                .totalPrice(totalPrice)
                .theaterAddress(theater.getAddress())
                .seatNos(ticketDto.getRequestedSeats().toString())
                .build();
        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);

        ticketRespository.save(ticket);

        return "booked ticket successfully";
    }
}
