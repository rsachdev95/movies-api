package rsachdev95.moviesapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rsachdev95.moviesapi.MoviesApiApplication;
import rsachdev95.moviesapi.model.Movie;
import rsachdev95.moviesapi.service.MovieService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "movies")
public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MoviesApiApplication.APPLICATION_NAME_SPACE);

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> listMovies() {
        LOG.info("Getting all movies");
        List<Movie> movies = movieService.findAll();
        if(movies.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping(value = "/most-comments")
    public ResponseEntity<String> getUserWithMostComments() {
        String user;

        LOG.info("Getting user who added the most comments");
        try {
            user = movieService.findMostFrequentCommenter();
        } catch (NoSuchElementException nse) {
            LOG.error("Service returned a NoSuchElementException: " + nse.toString());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping(value = "/most-likes")
    public ResponseEntity<String> getMovieWithMostLikes() {
        String movie;

        LOG.info("Getting movie with most likes");
        try {
            movie = movieService.findMostLikes();
        } catch (NoSuchElementException nse) {
            LOG.error("Service returned a NoSuchElementException: " + nse.toString());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @GetMapping(value="/{movie-id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movie-id") String id) {
        LOG.info("Getting movie with id: " + id);
        Movie movie = movieService.findById(id);
        if(movie == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
}
