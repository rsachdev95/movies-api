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

    /**
     * Returns a list of all {@link Movie} in the database.
     *
     * @return list of movies
     */
    public List<Movie> findAll() {
        List<Movie> movies = movieRepository.findAll();
        if(movies.isEmpty()) {
            LOG.error("There are no movies to display at this moment.");
            return Collections.emptyList();
        }
        return movies;
    }

    /**
     * Generates a map of usernames and frequency
     * and determines the max frequency
     *
     * @return the most frequent username occurrency
     */
    public String findMostFrequentCommenter() {
        List<Movie> movies = findAll();

        List<String> users = getOccurrencesOfUsername(movies);

        Map.Entry<String, Long> frequency = users.stream()
                                                 .collect(Collectors.groupingBy(u -> u, Collectors.counting()))
                                                 .entrySet()
                                                 .stream()
                                                 .max(Comparator.comparing(Map.Entry::getValue))
                                                 .orElseThrow(NoSuchElementException::new);
        return frequency.getKey();
    }

    /**
     * Gets a list of all users from the provided {@link Movie} list
     * by streaming a list of comments and adding each occurrence of
     * a username
     *
     * @param movies : list of all movies
     * @return a list of users
     */
    private List<String> getOccurrencesOfUsername(List<Movie> movies) {

        return movies.stream()
                .flatMap(m -> m.getComments().stream())
                .map(Comment::getUser)
                .collect(Collectors.toList());
    }

    /**
     * Finds the max of the movie by checking its 'likes'
     * attribute.
     *
     * @return title of movie
     */
    public String findMostLikes() {
        List<Movie> movies = findAll();
        Movie movie = movies.stream()
                            .max(Comparator.comparing(Movie::getLikes))
                            .orElseThrow(NoSuchElementException::new);
        return movie.getTitle();
    }

    /**
     * Fetches a {@link Movie} by its corresponding id
     *
     * @param id of the movie
     * @return {@link Movie}
     */
    public Movie findById(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(!movie.isPresent()) {
            LOG.error("Movie id: " + id + " does not exist");
            return null;
        }

        return movie.get();
    }
}
