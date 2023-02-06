package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static model.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WatchListsTest {

    WatchLists watchlist;
    Movie mv1;
    Movie mv2;
    Movie mv3;
    Show sw1;
    Show sw2;
    Show sw3;

    @BeforeEach
    public void runBefore() {
        watchlist = new WatchLists();
        mv1 = new Movie("MvName1", TO_WATCH);
        mv2 = new Movie("MvName2", WATCHING);
        mv3 = new Movie("MvName3", WATCHED);
        sw1 = new Show("SwName1", 12, 0, TO_WATCH);
        sw2 = new Show("SwName2", 12, 6, WATCHING);
        sw3 = new Show("SwName3", 12, 12, WATCHED);

    }

    @Test
    public void testAddToWatchMovie() {
        watchlist.addMovie(mv1);
        assertEquals(mv1, watchlist.getToWatchList().get(0));
    }

    @Test
    public void testAddWatchingMovie(){
        watchlist.addMovie(mv2);
        assertEquals(mv2, watchlist.getWatchingList().get(0));
    }

    @Test
    public void testAddWatchedMovie() {
        watchlist.addMovie(mv3);
        assertEquals(mv3, watchlist.getWatchedList().get(0));
    }

    @Test
    public void testAddToWatchShow() {
        watchlist.addShow(sw1);
        assertEquals(sw1, watchlist.getToWatchList().get(0));
    }

    @Test
    public void testAddWatchingShow() {
        watchlist.addShow(sw2);
        assertEquals(sw2, watchlist.getWatchingList().get(0));
    }

    @Test
    public void testAddWatchedShow() {
        watchlist.addShow(sw3);
        assertEquals(sw3, watchlist.getWatchedList().get(0));
    }
}