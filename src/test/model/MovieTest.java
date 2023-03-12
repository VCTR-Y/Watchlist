package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    Movie movie1;
    Movie movie2;
    Movie movie3;

    @BeforeEach
    public void runBefore() {
        movie1 = new Movie("M1", TO_WATCH);
        movie2 = new Movie("M2", WATCHING);
        movie3 = new Movie("M3", WATCHED);
    }

    @Test
    public void testConstructor() {
        assertEquals("M1", movie1.getMovieName());
        assertEquals(TO_WATCH, movie1.getMovieStatus());
        assertEquals(0, movie1.getMovieRating());
    }

    @Test
    public void testChangeMovieStatusToWatching() {
        movie1.changeMovieStatusToWatching();
        assertEquals(WATCHING, movie1.getMovieStatus());
    }

    @Test
    public void testChangeMovieStatusToWatched() {
        movie1.changeMovieStatusToWatched();
        movie2.changeMovieStatusToWatched();
        assertEquals(WATCHED, movie1.getMovieStatus());
        assertEquals(WATCHED, movie2.getMovieStatus());
    }

    @Test
    public void testChangeMovieRating() {
        movie1.changeMovieStatusToWatched();
        movie1.changeMovieRating(5);
        assertEquals(5, movie1.getMovieRating());
        movie1.changeMovieRating(9);
        assertEquals(9,movie1.getMovieRating());
    }
}
