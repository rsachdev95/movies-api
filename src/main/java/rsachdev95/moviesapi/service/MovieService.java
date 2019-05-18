package rsachdev95.moviesapi.service;

import rsachdev95.moviesapi.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    String findMostFrequentCommenter();
    String findMostLikes();
}
