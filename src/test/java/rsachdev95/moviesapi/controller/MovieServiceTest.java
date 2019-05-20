package rsachdev95.moviesapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rsachdev95.moviesapi.model.Comment;
import rsachdev95.moviesapi.model.Movie;
import rsachdev95.moviesapi.repository.MovieRepository;
import rsachdev95.moviesapi.service.MovieService;
import rsachdev95.moviesapi.service.impl.MovieServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieServiceTest {

    private static final String ID = "id";

    @Mock
    private List<Movie> movies;

    @Mock
    private Movie movie;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Test
    @DisplayName("Tests successful retrieval of list of all movies")
    public void testGetSuccessfulMovies() {
        when(movieRepository.findAll()).thenReturn(movies);
        List<Movie> moviesFromService = movieService.findAll();

        assertNotNull(moviesFromService);
        assertEquals(movies, moviesFromService);
    }

    @Test
    @DisplayName("Tests unsuccessful retrieval of list of all movies")
    public void testGetUnsuccessfulMovies() {
        when(movieRepository.findAll()).thenReturn(Collections.emptyList());
        List<Movie> moviesFromService = movieService.findAll();

        assertEquals(Collections.emptyList(), moviesFromService);
    }

    @Test
    @DisplayName("Tests find most frequent commenter")
    public void testFindMostFrequentCommenter() {
        List<Movie> moviesList = createMovies();

        when(movieRepository.findAll()).thenReturn(moviesList);
        String highestCommenter = movieService.findMostFrequentCommenter();

        assertNotNull(highestCommenter);
        assertEquals("user", highestCommenter);
    }

    @Test
    @DisplayName("Tests find movie with highest likes")
    public void testFindMovieWithHighestLikes() {
        List<Movie> moviesList = createMovies();

        when(movieRepository.findAll()).thenReturn(moviesList);
        String movieTitle = movieService.findMostLikes();

        assertNotNull(movieTitle);
        assertEquals("title", movieTitle);
    }

    @Test
    @DisplayName("Tests successful find movie by ID")
    public void testGetSuccessfulMovieById() {
        when(movieRepository.findById(ID)).thenReturn(Optional.of(movie));
        Movie movieFromService = movieService.findById(ID);

        assertNotNull(movieFromService);
        assertEquals(movie, movieFromService);
    }

    @Test
    @DisplayName("Tests unsuccessful find movie by ID")
    public void testGetUnsuccessfulMovieById() {
        when(movieRepository.findById(ID)).thenReturn(Optional.empty());
        Movie movieFromService = movieService.findById(ID);

        assertNull(movieFromService);
    }

    private List<Movie> createMovies() {
        List<Movie> moviesList = new ArrayList<>();
        Movie movie = new Movie();
        Movie movie2 = new Movie();

        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setUser("user");
        Comment comment2 = new Comment();
        comment2.setUser("user");
        commentList.add(comment);
        commentList.add(comment2);

        List<Comment> commentList2 = new ArrayList<>();
        Comment comment3 = new Comment();
        comment3.setUser("user");
        Comment comment4 = new Comment();
        comment4.setUser("user1");
        commentList2.add(comment3);
        commentList2.add(comment4);

        movie.setComments(commentList);
        movie2.setComments(commentList2);
        movie.setLikes(1000);
        movie.setTitle("title");
        movie2.setLikes(500);
        movie2.setTitle("title1");
        moviesList.add(movie);
        moviesList.add(movie2);

        return moviesList;
    }
}
