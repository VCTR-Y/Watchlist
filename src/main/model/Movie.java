package model;

public class Movie {

    private static String name;
    private static Status status;

    public Movie(String movieName, Status movieStatus) {
        this.name = movieName;
        this.status = movieStatus;
    }

    // EFFECTS: returns the name of the movie
    public String getMovieName() {
        return name;
    }

    // EFFECTS: returns the status of the movie
    public Status getMovieStatus() {
        return status;
    }
}
