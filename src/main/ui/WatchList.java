package ui;

import model.Movie;
import model.Show;
import model.Status;
import model.WatchLists;
import java.util.Scanner;

// WatchList Application
public class WatchList {
    private WatchLists watchlist;
    private Scanner input;

    public WatchList() {
        runWatchList();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runWatchList() {
        String command = null;
        boolean keepGoing = true;
        watchlist = new WatchLists();
        input = new Scanner(System.in);
        while (keepGoing) {
            displayMainMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: displays menu of options to user
    private void displayMainMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("\tv -> View my WatchList");
        System.out.println("\tm -> Modify my WatchList");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("v")) {
            displayViewMenu();
        } else if (command.equals("m")) {
            displayModifyMenu();
        } else {
            System.out.println("Invalid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: displays a menu of which list to view
    private void displayViewMenu() {
        String selection = "";
        while (!(selection.equals("tw") || selection.equals("w") || selection.equals("wd") || selection.equals("b"))) {
            System.out.println("Which list would you like to view?");
            System.out.println("\ttw -> ToWatch");
            System.out.println("\tw -> Watching");
            System.out.println("\twd -> Watched");
            System.out.println("\tb -> Back");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("tw")) {
            displayToWatchMenu();
        } else if (selection.equals("w")) {
            displayWatchingMenu();
        } else if (selection.equals("wd")) {
            displayWatchedMenu();
        } else {
            displayMainMenu();
        }
    }

    // MODIFIES: this
    // EFFECTS: prints out the shows and movies in the to watch list
    private void displayToWatchMenu() {
        if (watchlist.getToWatchList().size() == 0) {
            System.out.println("There are currently no movies/shows in this list");
        } else {
            for (Object object : watchlist.getToWatchList()) {
                if (object instanceof Show) {
                    System.out.println(" - " + ((Show) object).getShowName() + " | Episodes: "
                            + ((Show) object).getShowEpisodesWatched() + "/" + ((Show) object).getShowEpisodes());
                } else if (object instanceof Movie) {
                    System.out.println(" - " + ((Movie) object).getMovieName());
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: prints out the shows and movies in the watching list
    private void displayWatchingMenu() {
        if (watchlist.getWatchingList().size() == 0) {
            System.out.println("There are currently no movies/shows in this list");
        } else {
            for (Object object : watchlist.getWatchingList()) {
                if (object instanceof Show) {
                    System.out.println(" - " + ((Show) object).getShowName() + " | Episodes: "
                            + ((Show) object).getShowEpisodesWatched() + "/" + ((Show) object).getShowEpisodes());
                } else if (object instanceof Movie) {
                    System.out.println(" - " + ((Movie) object).getMovieName());
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: prints out the shows and movies in the watched list
    private void displayWatchedMenu() {
        if (watchlist.getWatchedList().size() == 0) {
            System.out.println("There are currently no movies/shows in this list");
        } else {
            for (Object object : watchlist.getWatchedList()) {
                if (object instanceof Show) {
                    System.out.println(" - " + ((Show) object).getShowName() + " | Episodes: "
                            + ((Show) object).getShowEpisodesWatched() + "/"
                            + ((Show) object).getShowEpisodes() + " | Rating: "
                            + ((Show) object).getShowRating() + "/" + "10");
                } else if (object instanceof Movie) {
                    System.out.println(" - " + ((Movie) object).getMovieName() + " | Rating: "
                            + ((Movie) object).getMovieRating() + "/" + "10");
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: displays a menu of modify options
    private void displayModifyMenu() {
        String selection = "";
        while (!(selection.equals("am") || selection.equals("as") || selection.equals("ch") || selection.equals("b"))) {
            System.out.println("Would you like to do with your WatchList?");
            System.out.println("\tam -> Add a movie");
            System.out.println("\tas -> Add a show");
            System.out.println("\tch -> Modify a show/movie");
            System.out.println("\tb -> Back");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("am")) {
            displayMovieMenu();
        } else if (selection.equals("as")) {
            displayShowMenu();
        } else if (selection.equals("ch")) {
            displayChangeStatusMenu();
        } else {
            displayMainMenu();
        }
    }

    // MODIFIES: this
    // EFFECTS: Adds a movie
    private void displayMovieMenu() {
        System.out.println("What is the status of your movie?");
        chooseMovieStatus();
    }

    // MODIFIES: this
    // EFFECTS: Adds a show
    private void displayShowMenu() {
        System.out.println("What is the status of your show?");
        chooseShowStatus();
    }

    // MODIFIES: this
    // EFFECTS: Changes the status of a show or movie
    private void displayChangeStatusMenu() {
        String selection = "";
        while (!(selection.equals("tw") || selection.equals("w") || selection.equals("wd") || selection.equals("b"))) {
            System.out.println("What is the current status of the show/movie you'd like to modify?");
            System.out.println("\ttw -> ToWatch");
            System.out.println("\tw -> Watching");
            System.out.println("\tb -> Back");
            selection = input.next();
            selection = selection.toLowerCase();
        }
        if (selection.equals("tw")) {
            changeToWatchStatus();
        } else if (selection.equals("w")) {
            changeWatchingStatus();
        } else {
            displayMainMenu();
        }
    }

    // REQUIRES: this.status == TO_WATCH
    // MODIFIES: this
    // EFFECTS: Changes the status of a TO_WATCH show/movie to either WATCHING or WATCHED
    private void changeToWatchStatus() {
        if (watchlist.getToWatchList().size() == 0) {
            System.out.println("There are currently no movies/shows in this list");
        } else {
            displayToWatchMenu();
            String selection = "";
            while (!(selection.equals("w") || selection.equals("wd"))) {
                System.out.println("Would you like to update its status to Watching or Watched?");
                System.out.println("\tw -> Watching");
                System.out.println("\twd -> Watched");
                selection = input.next();
                selection = selection.toLowerCase();
            }

            if (selection.equals("w")) {
                changeToWatchToWatching();
            } else {
                changeToWatchToWatched();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Changes the status of a TO_WATCH show/movie to WATCHING
    private void changeToWatchToWatching() {
        System.out.println("What's the index of the show/movie you'd like to change?");
        int index = input.nextInt();
        Object change = watchlist.getToWatchList().get(index);
        if (change instanceof Show) {
            System.out.println("How many episodes have you watched?");
            int episodes = input.nextInt();
            ((Show) change).changeEpisodesWatched(episodes);
            watchlist.moveShowToWatchingList((Show) change);
        } else if (change instanceof Movie) {
            watchlist.moveMovieToWatchingList((Movie) change);
        }
    }

    // MODIFIES: this
    // EFFECTS: Changes the status of a TO_WATCH show/movie to WATCHED
    private void changeToWatchToWatched() {
        System.out.println("What's the index of the show/movie you'd like to change?");
        int index = input.nextInt();
        Object change = watchlist.getToWatchList().get(index);
        if (change instanceof Show) {
            ((Show) change).changeEpisodesWatched(((Show) change).getShowEpisodes());
            System.out.println("What is your rating for this show from 1-10?");
            int rating = input.nextInt();
            ((Show) change).changeShowRating(rating);
            watchlist.moveShowToWatchedList((Show) change);
        } else if (change instanceof Movie) {
            System.out.println("What is your rating for this show from 1-10?");
            int rating = input.nextInt();
            ((Movie) change).changeMovieRating(rating);
            watchlist.moveMovieToWatchedList((Movie) change);
        }
    }

    // REQUIRES: this.status == WATCHING
    // MODIFIES: this
    // EFFECTS: Changes the status of a watching show/movie to Watched
    private void changeWatchingStatus() {
        if (watchlist.getWatchingList().size() == 0) {
            System.out.println("There are currently no movies/shows in this list");
        } else {
            displayWatchingMenu();
            String selection = "";
            while (!(selection.equals("e") || selection.equals("s"))) {
                System.out.println("Do you want to update episodes or update status?");
                System.out.println("\te -> Episodes");
                System.out.println("\ts -> Update Status to Watched");
                selection = input.next();
                selection = selection.toLowerCase();
            }

            if (selection.equals("e")) {
                changeWatchingEpisodes();
            } else if (selection.equals("s")) {
                changeWatchingToWatched();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Changes the amount of episodes watched for a WATCHING show
    private void changeWatchingEpisodes() {
        System.out.println("What's the index of the show you'd like to change?");
        int index = input.nextInt();
        Object change = watchlist.getWatchingList().get(index);
        if (change instanceof Show) {
            System.out.println("How many episodes have you watched?");
            int episodes = input.nextInt();
            ((Show) change).changeEpisodesWatched(episodes);
        }
    }

    // MODIFIES: this
    // EFFECTS: Changes a show with WATCHING status to WATCHED status
    private void changeWatchingToWatched() {
        System.out.println("What's the index of the show/movie you'd like to change?");
        int index = input.nextInt();
        Object change = watchlist.getWatchingList().get(index);
        if (change instanceof Show) {
            System.out.println("What is your rating for this show from 1-10?");
            int rating = input.nextInt();
            ((Show) change).changeShowRating(rating);
            ((Show) change).changeEpisodesWatched(((Show) change).getShowEpisodes());
            watchlist.moveShowToWatchedList((Show) change);
        } else if (change instanceof Movie) {
            System.out.println("What is your rating for this movie from 1-10?");
            int rating = input.nextInt();
            ((Movie) change).changeMovieRating(rating);
            watchlist.moveMovieToWatchedList((Movie) change);
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates a new movie instance and adds it to the list by its status
    private void chooseMovieStatus() {
        String selection = "";
        while (!(selection.equals("tw") || selection.equals("w") || selection.equals("wd") || selection.equals("b"))) {
            System.out.println("\ttw -> To Watch");
            System.out.println("\tw -> Watching");
            System.out.println("\twd -> Watched");
            System.out.println("\tb -> Back");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("tw")) {
            makeNewToWatchMovie();
        } else if (selection.equals("w")) {
            makeNewWatchingMovie();
        } else if (selection.equals("wd")) {
            makeNewWatchedMovie();
        } else {
            displayMainMenu();
        }
    }

    // MODIFIES: this
    // EFFECTS: Makes a new show with TO_WATCH status and adds it to the correct list
    private void makeNewToWatchMovie() {
        System.out.println("What is the name of the movie?");
        input.nextLine();
        String movieName = input.nextLine();
        Movie movie = new Movie(movieName, Status.TO_WATCH);
        watchlist.addMovie(movie);
        System.out.println("Movie was successfully added!");
    }

    // MODIFIES: this
    // EFFECTS: Makes a new movie with WATCHING status and adds it to the correct list
    private void makeNewWatchingMovie() {
        System.out.println("What is the name of the movie?");
        input.nextLine();
        String movieName = input.nextLine();
        Movie movie = new Movie(movieName, Status.WATCHING);
        watchlist.addMovie(movie);
        System.out.println("Movie was successfully added!");
    }

    // MODIFIES: this
    // EFFECTS: Makes a new movie with WATCHED status and adds it to the correct list
    private void makeNewWatchedMovie() {
        System.out.println("What is the name of the movie?");
        input.nextLine();
        String movieName = input.nextLine();
        Movie movie = new Movie(movieName, Status.WATCHED);
        System.out.println("What is your rating for this movie from 1-10?");
        int rating = input.nextInt();
        movie.changeMovieRating(rating);
        watchlist.addMovie(movie);
        System.out.println("Movie was successfully added!");
    }

    // MODIFIES: this
    // EFFECTS: Creates a new show instance and adds it to the list by its status
    private void chooseShowStatus() {
        String selection = "";
        while (!(selection.equals("tw") || selection.equals("w") || selection.equals("wd") || selection.equals("b"))) {
            System.out.println("\ttw -> To Watch");
            System.out.println("\tw -> Watching");
            System.out.println("\twd -> Watched");
            System.out.println("\tb -> Back");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("tw")) {
            makeNewToWatchShow();
        } else if (selection.equals("w")) {
            makeNewWatchingShow();
        } else if (selection.equals("wd")) {
            makeNewWatchedShow();
        } else {
            displayMainMenu();
        }
    }

    // MODIFIES: this
    // EFFECTS: Makes a new show with TO_WATCH status and adds it to the correct list
    private void makeNewToWatchShow() {
        System.out.println("What is the name of the show?");
        input.nextLine();
        String showName = input.nextLine();
        System.out.println("How many episodes does the show have?");
        int showEpisodes = input.nextInt();
        Show show = new Show(showName, showEpisodes, 0, Status.TO_WATCH);
        watchlist.addShow(show);
        System.out.println("Show was successfully added!");

    }

    // MODIFIES: this
    // EFFECTS: Makes a new show with WATCHING status and adds it to the correct list
    private void makeNewWatchingShow() {
        System.out.println("What is the name of the show?");
        input.nextLine();
        String showName = input.nextLine();
        System.out.println("How many episodes does the show have?");
        int showEpisodes = input.nextInt();
        System.out.println("How many episodes have you watched?");
        int showEpisodesWatched = input.nextInt();
        Show show = new Show(showName, showEpisodes, showEpisodesWatched, Status.WATCHING);
        watchlist.addShow(show);
        System.out.println("Show was successfully added!");
    }

    // MODIFIES: this
    // EFFECTS: Makes a new show with WATCHED status and adds it to the correct list
    private void makeNewWatchedShow() {
        System.out.println("What is the name of the show?");
        input.nextLine();
        String showName = input.nextLine();
        System.out.println("How many episodes does the show have?");
        int showEpisodes = input.nextInt();
        Show show = new Show(showName, showEpisodes, showEpisodes, Status.WATCHED);
        System.out.println("What is your rating for this show from 1-10?");
        int rating = input.nextInt();
        show.changeShowRating(rating);
        watchlist.addShow(show);
        System.out.println("Show was successfully added!");
    }
}
