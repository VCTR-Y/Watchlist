package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a show having a name, episodes, number of episodes watched, status, and rating
public class Show implements Writable {

    private String name;
    private int episodes;
    private int episodesWatched;
    private Status status;
    private int rating;

    public Show(String showName, int showEpisodes, int showEpisodesWatched, Status showStatus) {
        this.name = showName;
        this.episodes = showEpisodes;
        this.episodesWatched = showEpisodesWatched;
        this.status = showStatus;
        this.rating = 0;
    }

    // REQUIRES: this.status == TO_WATCH
    // MODIFIES: This
    // EFFECTS: Changes the status of the show to "WATCHING"
    public void changeShowStatusToWatching() {
        this.status = Status.WATCHING;
    }

    // REQUIRES: this.status == TO_WATCH || this.status == WATCHING
    // MODIFIES: This
    // EFFECTS: Changes the status of the show to "WATCHED"
    public void changeShowStatusToWatched() {
        this.status = Status.WATCHED;
    }

    // REQUIRES: rating is a value from 1-10
    // MODIFIES: This
    // EFFECTS: Changes the rating of the show
    public void changeShowRating(int rating) {
        this.rating = rating;
    }

    public void changeEpisodesWatched(int episodesWatched) {
        this.episodesWatched = episodesWatched;
    }

    // EFFECTS: returns the name of the show
    public String getShowName() {
        return name;
    }

    // EFFECTS: returns the number of episodes the show has
    public int getShowEpisodes() {
        return episodes;
    }

    public int getShowEpisodesWatched() {
        return episodesWatched;
    }

    // EFFECTS: returns the status of the show
    public Status getShowStatus() {
        return status;
    }

    // EFFECTS: returns the rating of the show
    public int getShowRating() {
        return rating;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("episodes", episodes);
        json.put("episodes watched", episodesWatched);
        json.put("status", status);
        return json;
    }
}
