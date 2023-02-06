package model;

// Represents a movie having a name, status, and rating
public class Movie {

    private String name;
    private Status status;
    private Rating rating;

    public Movie(String movieName, Status movieStatus) {
        this.name = movieName;
        this.status = movieStatus;
        this.rating = Rating.NotCompleted;
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
