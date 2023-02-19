package model;

// Represents a show having a name, episodes, number of episodes watched, status, and rating
public class Show {

    private String name;
    private int episodes;
    private int episodesWatched;
    private Status status;
    private Rating rating;

    public Show(String showName, int showEpisodes, int showEpisodesWatched, Status showStatus) {
        this.name = showName;
        this.episodes = showEpisodes;
        this.episodesWatched = showEpisodesWatched;
        this.status = showStatus;
        this.rating = Rating.NOT_COMPLETED;
    }

    // REQUIRES: !!!
    // MODIFIES: This
    // EFFECTS: Changes the status of the show to "WATCHING"
    public void changeShowStatusToWatching() {
        this.status = Status.WATCHING;
    }

    // REQUIRES: !!!
    // MODIFIES: This
    // EFFECTS: Changes the status of the show to "WATCHED"
    public void changeShowStatusToWatched() {
        this.status = Status.WATCHED;
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
        return rating.getNumRating();
    }
}
