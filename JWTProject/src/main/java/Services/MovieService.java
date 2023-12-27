package Services;

import Model.Movie;
import Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    //Get all Courses
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    // Get learner by id
    public Movie getMovieById(int id){
        return movieRepository.findById(id).get();
    }

    // Create User
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    //Remove User
    public void removeMoviesById(int id){
        Optional<Movie> tempUser = movieRepository.findById(id);
        if(tempUser.isEmpty()){
            throw new RuntimeException("User id" + id + "doesn't exist");
        }
        movieRepository.deleteById(id);
    }

    //Remove all learners
    public void removeAllMovies(){
        movieRepository.deleteAll();
    }

}
