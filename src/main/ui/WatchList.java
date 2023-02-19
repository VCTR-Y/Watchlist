package ui;

import model.Movie;
import model.Status;
import model.Rating;
import model.WatchLists;
import java.util.Scanner;

// WatchList Application
public class WatchList {
    private WatchLists watchlist;
    private Scanner input;

    public WatchList() {
        runWatchList();
    }

    private void runWatchList() {
        WatchLists watchList = new WatchLists();
        boolean keepGoing = true;
        input = new Scanner(System.in);
        while (keepGoing) {
            displayMainMenu();
            String command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("\tv -> View my WatchList");
        System.out.println("\tm -> Modify my WatchList");
        System.out.println("\tq -> Quit");

    }

    private void processCommand(String command)  {
        if (command.equals("v")) {
            displayViewMenu();
        } else if (command.equals("m")) {
            displayModifyMenu();
        } else {
            System.out.println("Invalid selection");
        }
    }

    private void displayViewMenu() {
        String selection = null;
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

        }
    }

    private void displayModifyMenu() {
        String selection = null;
        while (!(selection.equals("am") || selection.equals("as") || selection.equals("ch") || selection.equals("b"))) {
            System.out.println("Would you like to do with your WatchList?");
            System.out.println("\tam -> Add a movie");
            System.out.println("\tas -> Add a show");
            System.out.println("\tch -> Change the status of a show/movie");
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
    private void displayMovieMenu() {
        System.out.println("What is the status of your movie?");
        chooseStatus();
    }
    private void displayShowMenu() {
        System.out.println("What is the status of your show?");
        chooseStatus();
    }

    private void displayChangeStatusMenu() {

    }


    private void chooseStatus() {
        String selection = null;
        while (!(selection.equals("tw") || selection.equals("w") || selection.equals("wd") || selection.equals("b"))) {
            System.out.println("\ttw -> To Watch");
            System.out.println("\tw -> Watching");
            System.out.println("\twd -> Watched");
            System.out.println("\tb -> Back");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("tw")) {
            System.out.println("What is the name of the movie?");
            String movieName = input.nextLine();
            Movie movie = new Movie(movieName, Status.TO_WATCH);
            watchlist.addMovie(movie);
            System.out.println("Movie was successfully added!");
        } else if (selection.equals("w")) {
            System.out.println("What is the name of the movie?");
            String movieName = input.nextLine();
            Movie movie = new Movie(movieName, Status.WATCHING);
            watchlist.addMovie(movie);
        } else if (selection.equals("wd")) {
            System.out.println("What is the name of the movie?");
            String movieName = input.nextLine();
            Movie movie = new Movie(movieName, Status.WATCHED);
            System.out.println("What is your rating for this movie from 1-10?");
            int rating = input.nextInt();



        } else {
            displayMainMenu();
        }
    }
}
