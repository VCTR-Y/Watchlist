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
        assertEquals(Rating.NotCompleted.getNumRating(), movie1.getMovieRating());
    }

}
