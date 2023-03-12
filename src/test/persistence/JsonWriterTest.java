package persistence;

import model.Status;
import model.Show;
import model.Movie;
import model.WatchLists;
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
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWatchList.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWatchList.json");
            wl = reader.read();
            assertEquals(1, wl.getToWatchList().size());
            assertEquals(1, wl.getWatchingList().size());
            assertEquals(1, wl.getWatchedList().size());
            checkMovie("Batman", Status.TO_WATCH, 0, (Movie) wl.getToWatchList().get(0));
            checkMovie("Spiderman", Status.WATCHED, 9, (Movie) wl.getWatchedList().get(0));
            checkShow("Squid Game", 9, 5, Status.WATCHING, 0, (Show) wl.getWatchingList().get(0));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
