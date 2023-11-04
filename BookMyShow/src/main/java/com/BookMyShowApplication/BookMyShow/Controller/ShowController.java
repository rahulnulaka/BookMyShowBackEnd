package com.BookMyShowApplication.BookMyShow.Controller;

import com.BookMyShowApplication.BookMyShow.DTO.ShowDto;
import com.BookMyShowApplication.BookMyShow.DTO.ShowSeatDto;
import com.BookMyShowApplication.BookMyShow.Entity.Show;
import com.BookMyShowApplication.BookMyShow.Entity.ShowSeats;
import com.BookMyShowApplication.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.ReadOnlyFileSystemException;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody ShowDto showDto){
        try{
            String res=showService.addShow(showDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/showSeats")
    public ResponseEntity<String> showSeats(@RequestBody ShowSeatDto showSeatDto){
        try {
            String res = showService.showSeats(showSeatDto);
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
