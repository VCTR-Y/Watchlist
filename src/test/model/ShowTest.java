package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowTest {

    Show show1;
    Show show2;
    Show show3;

    @BeforeEach
    public void runBefore() {
        show1 = new Show("S1", 12, 0, TO_WATCH);
        show2 = new Show("S2", 12, 6, WATCHING);
        show3 = new Show("S3", 12, 12, WATCHED);
    }

    @Test
    public void testConstructor() {
        assertEquals("S1", show1.getShowName());
        assertEquals(12, show1.getShowEpisodes());
        assertEquals(0, show1.getShowEpisodesWatched());
        assertEquals(TO_WATCH, show1.getShowStatus());
        assertEquals(0, show1.getShowRating());
    }

    @Test
    public void testChangeShowStatusToWatching() {
        show1.changeShowStatusToWatching();
        assertEquals(WATCHING, show1.getShowStatus());
    }

    @Test
    public void testChangeShowStatusToWatched() {
        show1.changeShowStatusToWatched();
        show2.changeShowStatusToWatched();
        assertEquals(WATCHED, show1.getShowStatus());
        assertEquals(WATCHED, show2.getShowStatus());
    }

    @Test
    public void testChangeShowRating() {
        show1.changeShowStatusToWatched();
        show1.changeShowRating(5);
        assertEquals(5, show1.getShowRating());
        show1.changeShowRating(9);
        assertEquals(9, show1.getShowRating());
    }

    @Test
    public void testChangeEpisodesWatched() {
        show1.changeEpisodesWatched(9);
        assertEquals(9, show1.getShowEpisodesWatched());
    }
}
