package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowTest {

    Show show1;

    @BeforeEach
    public void runBefore() {
        show1 = new Show("S1", 12, 0, TO_WATCH);
    }

    @Test
    public void testConstructor() {
        assertEquals("S1", show1.getShowName());
        assertEquals(12, show1.getShowEpisodes());
        assertEquals(0, show1.getShowEpisodesWatched());
        assertEquals(TO_WATCH, show1.getShowStatus());
    }
}
