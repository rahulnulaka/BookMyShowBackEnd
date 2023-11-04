package com.BookMyShowApplication.BookMyShow.Controller;

import com.BookMyShowApplication.BookMyShow.DTO.MovieDto;
import com.BookMyShowApplication.BookMyShow.Entity.Movie;
import com.BookMyShowApplication.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieDto movieDto){
        try {
            String res = movieService.addMovie(movieDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getMaxRevenueMovie")
    public ResponseEntity<String> getMaxRevenueMovie(){
        String res=movieService.getMaxRevenueMovie();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
