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
    public void testMoveMovieToWatchingList() {
        watchlist.addMovie(mv1);
        assertEquals(mv1, watchlist.getToWatchList().get(0));
        assertEquals(1, watchlist.getToWatchList().size());
        watchlist.moveMovieToWatchingList(mv1);
        assertEquals(0, watchlist.getToWatchList().size());
        assertEquals(mv1, watchlist.getWatchingList().get(0));
        assertEquals(1,watchlist.getWatchingList().size());
    }

    @Test
    public void testMoveMovieToWatchedList() {
        watchlist.addMovie(mv1);
        watchlist.addMovie(mv2);
        assertEquals(mv1, watchlist.getToWatchList().get(0));
        assertEquals(mv2, watchlist.getWatchingList().get(0));
        assertEquals(1, watchlist.getToWatchList().size());
        assertEquals(1,watchlist.getWatchingList().size());
        watchlist.moveMovieToWatchedList(mv1);
        assertEquals(0, watchlist.getToWatchList().size());
        assertEquals(mv1, watchlist.getWatchedList().get(0));
        assertEquals(1, watchlist.getWatchedList().size());
        watchlist.moveMovieToWatchedList(mv2);
        assertEquals(0, watchlist.getWatchingList().size());
        assertEquals(mv2, watchlist.getWatchedList().get(1));
        assertEquals(2, watchlist.getWatchedList().size());
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

    @Test
    public void testAddShowToWatchingList() {
        watchlist.addShow(sw1);
        assertEquals(sw1, watchlist.getToWatchList().get(0));
        assertEquals(1, watchlist.getToWatchList().size());
        watchlist.moveShowToWatchingList(sw1);
        assertEquals(0, watchlist.getToWatchList().size());
        assertEquals(sw1, watchlist.getWatchingList().get(0));
        assertEquals(1, watchlist.getWatchingList().size());
    }

    @Test
    public void testAddShowToWatchedList() {
        watchlist.addShow(sw1);
        watchlist.addShow(sw2);
        assertEquals(sw1, watchlist.getToWatchList().get(0));
        assertEquals(sw2, watchlist.getWatchingList().get(0));
        assertEquals(1, watchlist.getToWatchList().size());
        assertEquals(1, watchlist.getWatchingList().size());
        watchlist.moveShowToWatchedList(sw1);
        assertEquals(0, watchlist.getToWatchList().size());
        assertEquals(sw1, watchlist.getWatchedList().get(0));
        assertEquals(1, watchlist.getWatchedList().size());
        watchlist.moveShowToWatchedList(sw2);
        assertEquals(0, watchlist.getWatchingList().size());
        assertEquals(sw2, watchlist.getWatchedList().get(1));
        assertEquals(2, watchlist.getWatchedList().size());
    }

    @Test
    public void testRemoveMovie() {
        watchlist.addMovie(mv1);
        watchlist.addMovie(mv2);
        watchlist.addMovie(mv3);
        assertEquals(mv1, watchlist.getToWatchList().get(0));
        assertEquals(mv2, watchlist.getWatchingList().get(0));
        assertEquals(mv3, watchlist.getWatchedList().get(0));
        assertEquals(1, watchlist.getToWatchList().size());
        assertEquals(1, watchlist.getWatchingList().size());
        assertEquals(1, watchlist.getWatchedList().size());
        watchlist.removeMovie(mv1);
        watchlist.removeMovie(mv2);
        watchlist.removeMovie(mv3);
        assertEquals(0, watchlist.getToWatchList().size());
        assertEquals(0, watchlist.getWatchingList().size());
        assertEquals(0, watchlist.getWatchedList().size());
    }

    @Test
    public void testRemoveShow() {
        watchlist.addShow(sw1);
        watchlist.addShow(sw2);
        watchlist.addShow(sw3);
        assertEquals(sw1, watchlist.getToWatchList().get(0));
        assertEquals(sw2, watchlist.getWatchingList().get(0));
        assertEquals(sw3, watchlist.getWatchedList().get(0));
        assertEquals(1, watchlist.getToWatchList().size());
        assertEquals(1, watchlist.getWatchingList().size());
        assertEquals(1, watchlist.getWatchedList().size());
        watchlist.removeShow(sw1);
        watchlist.removeShow(sw2);
        watchlist.removeShow(sw3);
        assertEquals(0, watchlist.getToWatchList().size());
        assertEquals(0, watchlist.getWatchingList().size());
        assertEquals(0, watchlist.getWatchedList().size());
    }
}