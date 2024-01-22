package dev.arshnirmal.imdb_clone.controllers;

import dev.arshnirmal.imdb_clone.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    public MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(ObjectId id){
        return movieRepository.findById(id).orElse(null);
    }
}
