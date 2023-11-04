package com.BookMyShowApplication.BookMyShow.Controller;

import com.BookMyShowApplication.BookMyShow.DTO.TheaterDto;
import com.BookMyShowApplication.BookMyShow.DTO.TotalRevenueDto;
import com.BookMyShowApplication.BookMyShow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody TheaterDto theaterDto){
        String res=theaterService.addTheater(theaterDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/getTotalRevenueOnThatDay")
    public ResponseEntity<String> getTotalRevenueOfThatDay(@RequestBody TotalRevenueDto totalRevenueDto){
        try{
            String res=theaterService.getTotalRevenueOfThatDay(totalRevenueDto);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
