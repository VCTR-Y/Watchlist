package model;

public class Show {

    private static String name;
    private static int episodes;
    private static int episodesWatched;
    private static Status status;

    public Show(String showName, int showEpisodes, int showEpisodesWatched, Status showStatus) {
        this.name = showName;
        this.episodes = showEpisodes;
        this.episodesWatched = showEpisodesWatched;
        this.status = showStatus;
    }

    // EFFECTS; returns the name of the show
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
}
