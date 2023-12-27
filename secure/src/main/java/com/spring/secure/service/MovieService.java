package com.spring.secure.service;

import com.spring.secure.model.Movie;
import com.spring.secure.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    MovieRepository movieRepository;

    MovieService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public String getAllMovies()
    {
        var movieList = movieRepository.findAll();
        return  String.format("{\n\t\"message\": \"%d movies found\", \n\t \"data\": %s \n}", movieList.size(),movieList.toString());
    }

    public String insertMovie(Movie movie)
    {
        Movie savedMovie = movieRepository.save(movie);
        return String.format("{\n\t\"message\":\"Movie Details saved\", \n\t \"data\": %s \n}",savedMovie.toString());
    }


}
