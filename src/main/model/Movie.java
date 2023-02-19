package model;

// Represents a movie having a name, status, and rating
public class Movie {

    private String name;
    private Status status;
    private Rating rating;

    public Movie(String movieName, Status movieStatus) {
        this.name = movieName;
        this.status = movieStatus;
        this.rating = Rating.NOT_COMPLETED;
    }

    // REQUIRES: !!!
    // MODIFIES: This
    // EFFECTS: Changes the status of the movie to "WATCHING"
    public void changeMovieStatusToWatching() {
        this.status = Status.WATCHING;
    }

    // REQUIRES: !!!
    // MODIFIES: This
    // EFFECTS: Changes the status of the movie to "WATCHED"
    public void changeMovieStatusToWatched() {
        this.status = Status.WATCHED;
    }

    public void changeMovieRating(Rating rating) {
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
        return rating.getNumRating();
    }
}
