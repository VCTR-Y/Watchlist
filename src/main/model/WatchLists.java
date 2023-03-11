package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class WatchLists implements Writable {

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

    // REQUIRES: movie.getMovieStatus() == Status.TO_WATCH
    // MODIFIES: This
    // EFFECTS: Remove a movie from "toWatchList", change its status to "WATCHING", and add to "watchingList"
    public void moveMovieToWatchingList(Movie movie) {
        toWatchList.remove(movie);
        movie.changeMovieStatusToWatching();
        addMovie(movie);
    }

    // REQUIRES movie.getMovieStatus() != Status.WATCHED
    // MODIFIES: This
    // EFFECTS: Remove a movie from "toWatchList" or "watchingList", change its status to "WATCHED",
    //          and add to "watchedList".
    public void moveMovieToWatchedList(Movie movie) {
        if (movie.getMovieStatus() == Status.TO_WATCH) {
            toWatchList.remove(movie);
        } else {
            watchingList.remove(movie);
        }
        movie.changeMovieStatusToWatched();
        addMovie(movie);
    }

    // EFFECTS: show.getShowStatus() == Status.TO_WATCH
    // MODIFIES: This
    // EFFECTS: Remove a show from "toWatchList", change its status to "WATCHING" and add to "watchingList"
    public void moveShowToWatchingList(Show show) {
        toWatchList.remove(show);
        show.changeShowStatusToWatching();
        addShow(show);
    }
    
    // REQUIRES: show.getShowStatus() != Status.WATCHED
    // MODIFIES: This
    // EFFECTS: Remove a show from "toWatchList" or "watchingList", change its status to "WATCHED",
    //         and add to "watchedList".
    public void moveShowToWatchedList(Show show) {
        if (show.getShowStatus() == Status.TO_WATCH) {
            toWatchList.remove(show);
        } else {
            watchingList.remove(show);
        }
        show.changeShowStatusToWatched();
        addShow(show);
    }

    // MODIFIES: this
    // EFFECTS: removes a movie from a watchlist
    public void removeMovie(Movie movie) {
        if (movie.getMovieStatus() == Status.TO_WATCH) {
            toWatchList.remove(movie);
        } else if (movie.getMovieStatus() == Status.WATCHING) {
            watchingList.remove(movie);
        } else {
            watchedList.remove(movie);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes a show from a watchlist
    public void removeShow(Show show) {
        if (show.getShowStatus() == Status.TO_WATCH) {
            toWatchList.remove(show);
        } else if (show.getShowStatus() == Status.WATCHING) {
            watchingList.remove(show);
        } else {
            watchedList.remove(show);
        }
    }

    // EFFECTS: returns the toWatchList
    public List<Object> getToWatchList() {
        return toWatchList;
    }

    // EFFECTS: returns the watchingList
    public List<Object> getWatchingList() {
        return watchingList;
    }

    // EFFECTS: returns the watchedList
    public List<Object> getWatchedList() {
        return watchedList;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        JSONArray out = new JSONArray();
        JSONObject outer = new JSONObject();
        json.put("towatch list", toWatchToJson());
        json.put("watching list", watchingToJson());
        json.put("watched list", watchedToJson());
        out.put(json);
        outer.put("watchlist", out);
        return outer;
    }

    private JSONArray toWatchToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Object o : toWatchList) {
            jsonArray.put(o.toString());
//            if (o instanceof Show) {
//                jsonArray.put(((Show) o).toJson());
//            } else if (o instanceof Movie) {
//                jsonArray.put(((Movie) o).toJson());
//            }
        }
        return jsonArray;
    }

    private JSONArray watchingToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Object o : watchingList) {
            if (o instanceof Show) {
                jsonArray.put(((Show) o).toJson());
            } else if (o instanceof Movie) {
                jsonArray.put(((Movie) o).toJson());
            }
        }
        return jsonArray;
    }

    private JSONArray watchedToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Object o : watchedList) {
            if (o instanceof Show) {
                jsonArray.put(((Show) o).toJson());
            } else if (o instanceof Movie) {
                jsonArray.put(((Movie) o).toJson());
            }
        }
        return jsonArray;
    }
}
