package persistence;

import model.Status;
import model.Show;
import model.Movie;
import model.WatchLists;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WatchLists wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWatchList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWatchList.json");
        try {
            WatchLists wl = reader.read();
            assertEquals(0, wl.getToWatchList().size());
            assertEquals(0, wl.getWatchingList().size());
            assertEquals(0, wl.getWatchedList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testGeneralWatchList() {
        JsonReader reader = new JsonReader("./data/testGeneralWatchList.json");
        try {
            WatchLists wl = reader.read();
            assertEquals(1, wl.getToWatchList().size());
            assertEquals(1, wl.getWatchingList().size());
            assertEquals(1, wl.getWatchedList().size());
            checkMovie("Batman", Status.TO_WATCH, 0, (Movie) wl.getToWatchList().get(0));
            checkMovie("Spiderman", Status.WATCHED, 9, (Movie) wl.getWatchedList().get(0));
            checkShow("Squid Game", 9, 5, Status.WATCHING, 0, (Show) wl.getWatchingList().get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
