package persistence;

import model.Status;
import model.Movie;
import model.Show;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JsonTest {
    protected void checkMovie(String name, Status movieStatus, int rating, Movie movie) {
        assertEquals(name, movie.getMovieName());
        assertEquals(movieStatus, movie.getMovieStatus());
        assertEquals(rating, movie.getMovieRating());
    }

    protected void checkShow(String name, int showEpisodes, int showEpisodesWatched, Status showStatus, int rating, Show show) {
        assertEquals(name, show.getShowName());
        assertEquals(showEpisodes, show.getShowEpisodes());
        assertEquals(showEpisodesWatched, show.getShowEpisodesWatched());
        assertEquals(showStatus, show.getShowStatus());
        assertEquals(rating, show.getShowRating());
    }
}
