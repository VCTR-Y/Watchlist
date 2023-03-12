package persistence;

import model.Status;
import model.Show;
import model.Movie;
import model.WatchLists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {


    @Test
    void testWriterInvalidFile() {
        try {
            WatchLists wl = new WatchLists();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:file.json");
            writer.open();
            fail("IOException was expect");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWatchList() {
        try {
            WatchLists wl = new WatchLists();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWatchList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWatchList.json");
            wl = reader.read();
            assertEquals(0, wl.getToWatchList().size());
            assertEquals(0, wl.getWatchingList().size());
            assertEquals(0, wl.getWatchedList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWatchList() {
        try {
            WatchLists wl = new WatchLists();
            Movie batman = (new Movie("Batman", Status.TO_WATCH));
            Movie ironMan = (new Movie("Iron Man", Status.WATCHING));
            Movie spiderman = (new Movie("Spiderman", Status.WATCHED));
            Show breakingBad = (new Show("Breaking Bad", 62, 0, Status.TO_WATCH));
            Show squidGame = (new Show("Squid Game", 9, 5, Status.WATCHING));
            Show strangerThings = (new Show("Stranger Things", 8, 8, Status.WATCHED));
            spiderman.changeMovieRating(9);
            strangerThings.changeShowRating(8);
            wl.addMovie(batman);
            wl.addMovie(ironMan);
            wl.addMovie(spiderman);
            wl.addShow((breakingBad));
            wl.addShow(squidGame);
            wl.addShow(strangerThings);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWatchList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWatchList.json");
            wl = reader.read();
            assertEquals(2, wl.getToWatchList().size());
            assertEquals(2, wl.getWatchingList().size());
            assertEquals(2, wl.getWatchedList().size());
            checkMovie("Batman", Status.TO_WATCH, 0, (Movie) wl.getToWatchList().get(0));
            checkMovie("Iron Man", Status.WATCHING, 0, (Movie) wl.getWatchingList().get(0));
            checkMovie("Spiderman", Status.WATCHED, 9, (Movie) wl.getWatchedList().get(0));
            checkShow("Breaking Bad",62, 0, Status.TO_WATCH, 0, (Show) wl.getToWatchList().get(1));
            checkShow("Squid Game", 9, 5, Status.WATCHING, 0, (Show) wl.getWatchingList().get(1));
            checkShow("Stranger Things", 8, 8, Status.WATCHED, 8, (Show) wl.getWatchedList().get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
