package com.BookMyShowApplication.BookMyShow.Controller;

import com.BookMyShowApplication.BookMyShow.DTO.TicketDto;
import com.BookMyShowApplication.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketDto ticketDto){
        try{
            String res=ticketService.bookTicket(ticketDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
