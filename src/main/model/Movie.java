package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a movie having a name, status, and rating
public class Movie implements Writable {

    private String name;
    private Status status;
    private int rating;

    public Movie(String movieName, Status movieStatus) {
        this.name = movieName;
        this.status = movieStatus;
        this.rating = 0;
    }

    // REQUIRES: this.status == TO_WATCH
    // MODIFIES: This
    // EFFECTS: Changes the status of the movie to "WATCHING"
    public void changeMovieStatusToWatching() {
        this.status = Status.WATCHING;
    }

    // REQUIRES: this.status == TO_WATCH || this.status == WATCHING
    // MODIFIES: This
    // EFFECTS: Changes the status of the movie to "WATCHED"
    public void changeMovieStatusToWatched() {
        this.status = Status.WATCHED;
    }

    // REQUIRES: rating is a value from 1-10
    // MODIFIES: This
    // EFFECTS: Changes the rating of the movie
    public void changeMovieRating(int rating) {
        this.rating = rating;
    }

    // EFFECTS: returns the name of the movie
    public String getMovieName() {
        return name;
    }

    // EFFECTS: returns the status of the movie
    public Status getMovieStatus() {
        return status;
    }

    // EFFECTS: returns the rating of the movie
    public int getMovieRating() {
        return rating;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("status", status);
        json.put("rating", rating);
        return json;
    }
}
