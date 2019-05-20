package rsachdev95.moviesapi.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rsachdev95.moviesapi.model.Movie;
import rsachdev95.moviesapi.service.MovieService;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class MovieControllerTest {
    private static final String COMMENTER = "commenter";
    private static final String MOST_LIKED_MOVIE = "movie";
    private static final String ID = "id";

    @Mock
    private Movie movie;

    @Mock
    private List<Movie> movies;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @Test
    @DisplayName("Tests successful retrieval of list of all movies")
    public void testGetSuccessfulMovieList() {
        when(movieService.findAll()).thenReturn(movies);
        ResponseEntity response = movieController.listMovies();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());
    }

    @Test
    @DisplayName("Tests unsuccessful retrieval of list of all movies")
    public void testGetUnsuccessfulMovieList() {
        when(movieService.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity response = movieController.listMovies();

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("Tests successful retrieval of user who wrote the most comments")
    public void testGetSuccessfulMostComments() {
        when(movieService.findMostFrequentCommenter()).thenReturn(COMMENTER);
        ResponseEntity response = movieController.getUserWithMostComments();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(COMMENTER, response.getBody());
    }

    @Test
    @DisplayName("Tests unsuccessful retrieval of user who wrote the most comments")
    public void testGetUnsuccessfulMostComments() {
        when(movieService.findMostFrequentCommenter()).thenThrow(NoSuchElementException.class);
        ResponseEntity response = movieController.getUserWithMostComments();

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("Tests successful retrieval of most liked movie")
    public void testGetSuccessfulMostLikedMovie() {
        when(movieService.findMostLikes()).thenReturn(MOST_LIKED_MOVIE);
        ResponseEntity response = movieController.getMovieWithMostLikes();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MOST_LIKED_MOVIE, response.getBody());
    }

    @Test
    @DisplayName("Tests unsuccessful retrieval of most liked movie")
    public void testGetUnsuccessfulMostLikedMovie() {
        when(movieService.findMostLikes()).thenThrow(NoSuchElementException.class);
        ResponseEntity response = movieController.getMovieWithMostLikes();

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("Tests successful retrieval of a movie by id")
    public void testGetSuccessfulMovieById() {
        when(movieService.findById(ID)).thenReturn(movie);
        ResponseEntity response = movieController.getMovieById(ID);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movie, response.getBody());
    }

    @Test
    @DisplayName("Tests unsuccessful retrieval of a movie by id")
    public void testGetUnsuccessfulMovieById() {
        when(movieService.findById(ID)).thenReturn(null);
        ResponseEntity response = movieController.getMovieById(ID);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}
