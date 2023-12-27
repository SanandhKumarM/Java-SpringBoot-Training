package com.spring.secure.controller;

import com.spring.secure.model.Movie;
import com.spring.secure.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
   private MovieService movieService;

   @Autowired
    public MovieController(MovieService movieService)
   {
       this.movieService=movieService;
   }

   //add a movie
    @PostMapping("add-movie")
    public String saveMovie(@RequestBody Movie movie)
    {
        return movieService.insertMovie(movie);
    }

    //get movie

    @GetMapping("get-movie")
    public String getMovie()
    {
        return movieService.getAllMovies();
    }



}
