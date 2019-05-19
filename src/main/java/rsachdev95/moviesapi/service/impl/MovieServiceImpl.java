package rsachdev95.moviesapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsachdev95.moviesapi.MoviesApiApplication;
import rsachdev95.moviesapi.model.Comment;
import rsachdev95.moviesapi.model.Movie;
import rsachdev95.moviesapi.repository.MovieRepository;
import rsachdev95.moviesapi.service.MovieService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOG = LoggerFactory.getLogger(MoviesApiApplication.APPLICATION_NAME_SPACE);

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        List<Movie> movies = movieRepository.findAll();
        if(movies.isEmpty()) {
            LOG.error("There are no movies to display at this moment.");
            return Collections.emptyList();
        }
        return movies;
    }

    //TODO: sort this out eventually.
    public String findMostFrequentCommenter() {
        List<Movie> movies = findAll();
        List<String> users = movies.parallelStream()
                                   .flatMap(m -> m.getComments().parallelStream())
                                   .map(Comment::getUser)
                                   .collect(Collectors.toList());
        Map.Entry<String, Long> stringLongEntry = users.parallelStream()
                                                       .collect(Collectors.groupingBy(u -> u, Collectors.counting()))
                                                       .entrySet()
                                                       .parallelStream()
                                                       .max(Comparator.comparing(Map.Entry::getValue))
                                                       .orElseThrow(NoSuchElementException::new);
        return stringLongEntry.getKey();
    }

    public String findMostLikes() {
        List<Movie> movies = findAll();
        Movie movie = movies.parallelStream()
                            .max(Comparator.comparing(Movie::getLikes))
                            .orElseThrow(NoSuchElementException::new);
        return movie.getTitle();
    }

    public Movie findById(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(!movie.isPresent()) {
            LOG.error("Movie id: " + id + " does not exist");
            return null;
        }

        return movie.get();
    }
}
