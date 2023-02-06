package model;

public enum Rating {
    NotCompleted(0),        // ASK ABOUT NAMING CONVENTION FOR THIS
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private int numRating;

    Rating(int numRating) {
        this.numRating = numRating;
    }

    public int getNumRating() {
        return numRating;
    }
}
