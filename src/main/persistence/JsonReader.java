package persistence;

import model.Movie;
import model.Show;
import model.WatchLists;
import model.Status;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

/***************************************************************************************
 * Code is modelled off of this sample application:
 *    Title: JsonSerializationDemo
 *    Author: Paul Carter
 *    Date: 03/11/2022
 *    Availability: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 *
 ***************************************************************************************/

// Represents a reader that reads WatchLists from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WatchLists read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWatchLists(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses watchlists from JSON object and returns it
    private WatchLists parseWatchLists(JSONObject jsonObject) {
        WatchLists wl = new WatchLists();
        addToWatch(wl, jsonObject);
        addWatching(wl, jsonObject);
        addWatched(wl, jsonObject);
        return wl;
    }

    // MODIFIES: wl
    // EFFECTS: parses to watch shows and movies from JSON object and adds them watchlists
    private void addToWatch(WatchLists wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("towatch");
        for (Object json : jsonArray) {
            JSONObject next = (JSONObject) json;
            if (next.has("episodes")) {
                addShow(wl, next);
            } else {
                addMovie(wl, next);
            }
        }
    }

    // MODIFIES: wl
    // EFFECTS: parses watching shows movies from JSON object and adds them to watchlists
    private void addWatching(WatchLists wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("watching");
        for (Object json : jsonArray) {
            JSONObject next = (JSONObject) json;
            if (next.has("episodes")) {
                addShow(wl, next);
            } else {
                addMovie(wl, next);
            }
        }
    }

    // MODIFIES: wl
    // EFFECTS: parses watched shows and movies from JSON object and adds them to watchlists
    private void addWatched(WatchLists wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("watched");
        for (Object json : jsonArray) {
            JSONObject next = (JSONObject) json;
            if (next.has("episodes")) {
                addShow(wl, next);
            } else {
                addMovie(wl, next);
            }
        }
    }

    // MODIFIES: wl
    // EFFECTS: parses movie from JSON object and adds it to watchlists
    private void addMovie(WatchLists wl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Status status = Status.valueOf(jsonObject.getString("status"));
        int rating = jsonObject.getInt("rating");
        Movie movie = new Movie(name, status);
        movie.changeMovieRating(rating);
        wl.addMovie(movie);
    }


    // MODIFIES: wl
    // EFFECTS: parses show from JSON object and adds it to watchlists
    private void addShow(WatchLists wl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int showEpisodes = jsonObject.getInt("episodes");
        int showEpisodesWatched = jsonObject.getInt("episodes watched");
        Status status = Status.valueOf(jsonObject.getString("status"));
        int rating = jsonObject.getInt("rating");
        Show show = new Show(name, showEpisodes, showEpisodesWatched, status);
        show.changeShowRating(rating);
        wl.addShow(show);
    }

}
