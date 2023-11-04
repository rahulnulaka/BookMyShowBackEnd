package com.BookMyShowApplication.BookMyShow.Service;

import com.BookMyShowApplication.BookMyShow.DTO.ShowDto;
import com.BookMyShowApplication.BookMyShow.DTO.TheaterDto;
import com.BookMyShowApplication.BookMyShow.DTO.TotalRevenueDto;
import com.BookMyShowApplication.BookMyShow.Entity.Show;
import com.BookMyShowApplication.BookMyShow.Entity.Theater;
import com.BookMyShowApplication.BookMyShow.Entity.TheaterSeats;
import com.BookMyShowApplication.BookMyShow.Entity.Ticket;
import com.BookMyShowApplication.BookMyShow.Exceptions.TheaterNotFoundException;
import com.BookMyShowApplication.BookMyShow.Repository.ShowRepository;
import com.BookMyShowApplication.BookMyShow.Repository.TheaterRepository;
import com.BookMyShowApplication.BookMyShow.Transformers.TheaterSeatTransformer;
import com.BookMyShowApplication.BookMyShow.Transformers.TheaterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;
    public String addTheater(TheaterDto theaterDto) {

        Theater theater= TheaterTransformer.createTheater(theaterDto);
        List<TheaterSeats> theaterSeatsList= TheaterSeatTransformer.createTheaterSeats(theaterDto,theater);
        theater.setTheaterSeatsList(theaterSeatsList);
        theaterRepository.save(theater);
        return "Theater Successfully added to the db";
    }

    public String getTotalRevenueOfThatDay(TotalRevenueDto totalRevenueDto) throws Exception{
        Optional<Theater> optionalTheater=theaterRepository.findById(totalRevenueDto.getTheaterId());
        if(optionalTheater.isEmpty()){
            throw new TheaterNotFoundException("no theater present with id:"+totalRevenueDto.getTheaterId());
        }
        Theater theater=optionalTheater.get();
        List<Show> showList=showRepository.findShowsByTheaterAndShowDate(theater,totalRevenueDto.getDate());
        if(showList.isEmpty())throw new Exception("showlist is null");
        Integer totalRevenue=0;
        for(Show show:showList){
            List<Ticket> ticketList=show.getTicketList();
            for(Ticket ticket:ticketList){
                totalRevenue+=ticket.getTotalPrice();
            }
        }
        return "The totalRevenue of the theater is "+ totalRevenue;
    }
}
