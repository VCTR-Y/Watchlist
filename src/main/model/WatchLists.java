package model;

import java.util.ArrayList;
import java.util.List;

public class WatchLists {

    private List<Object> toWatchList;
    private List<Object> watchingList;
    private List<Object> watchedList;

    public WatchLists() {
        toWatchList = new ArrayList<>();
        watchingList = new ArrayList<>();
        watchedList = new ArrayList<>();
    }

    // EFFECTS: adds a movie to a watchlist
    public void addMovie(Movie movie) {
        if (movie.getMovieStatus() == Status.TO_WATCH) {
            toWatchList.add(movie);
        } else if (movie.getMovieStatus() == Status.WATCHING) {
            watchingList.add(movie);
        } else {
            watchedList.add(movie);
        }
    }

    // EFFECTS: adds a show to a watchlist
    public void addShow(Show show) {
        if (show.getShowStatus() == Status.TO_WATCH) {
            toWatchList.add(show);
        } else if (show.getShowStatus() == Status.WATCHING) {
            watchingList.add(show);
        } else {
            watchedList.add(show);
        }
    }

    public List<Object> getToWatchList() {
        return toWatchList;
    }

    public List<Object> getWatchingList() {
        return watchingList;
    }

    public List<Object> getWatchedList() {
        return watchedList;
    }
}
