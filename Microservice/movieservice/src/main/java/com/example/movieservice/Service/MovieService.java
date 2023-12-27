package com.example.movieservice.Service;

import com.example.movieservice.Model.Movie;
import com.example.movieservice.MovieRepository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public String saveMovie(Movie movie){
        Movie savedMovie = movieRepository.save(movie);

        return "{"+
                "\"message\":"+"\"Sucessfully Saved Movie\",\n"+"\"data\":"+savedMovie+",\n"+"}";
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
