package ui;

import model.Movie;
import model.Status;
import model.WatchLists;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A frame that lets the user add a movie
public class AddMovieFrame {
    private JFrame frame;
    private JPanel panel1;
    private JComboBox setStatus;
    private JComboBox rating;
    private JButton cancelButton;
    private JButton addMovieButton;
    private JTextField nameMovie;

    // EFFECTS: Creates a new AddMovieFrame
    public AddMovieFrame(WatchLists watchlist) {
        frame = new JFrame();
        frame.add(panel1);
        setButtons(watchlist);
        ratingEnable();
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    // EFFECTS: Returns the status selected in setStatus
    private Status setStatus() {
        if (setStatus.getSelectedItem().toString() == "To Watch") {
            return Status.TO_WATCH;
        } else if (setStatus.getSelectedItem().toString() == "Watching") {
            return Status.WATCHING;
        } else {
            return Status.WATCHED;
        }
    }

    // EFFECTS: Sets the functionalities of AddShowButton and CancelButton
    private void setButtons(WatchLists watchlist) {
        setAddMovieButton(watchlist);
        setCancelButton();
        rating.setEnabled(false);
    }

    // EFFECTS: Enables the user to select a rating if status is set to "Watched"
    private void ratingEnable() {
        setStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (setStatus.getSelectedItem().toString() == "Watched") {
                    rating.setEnabled(true);
                } else {
                    rating.setEnabled(false);
                }
            }
        });
    }

    // EFFECTS: Adds functionality to the Add Movie button
    private void setAddMovieButton(WatchLists watchlist) {
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameMovie.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter All Data");
                } else if (rating.getSelectedItem().toString() == "N/A"
                        && setStatus.getSelectedItem().toString() == "Watched") {
                    JOptionPane.showMessageDialog(null, "Please Give A Rating");
                } else {
                    Movie movie = new Movie(nameMovie.getText(), setStatus());
                    if (setStatus.getSelectedItem().toString() == "Watched") {
                        movie.changeMovieRating(Integer.parseInt(rating.getSelectedItem().toString()));
                    }
                    watchlist.addMovie(movie);
                    updateLists();
                    frame.setVisible(false);
                }
            }
        });
    }

    // EFFECTS: Updates the WatchList when a new Movie has been added
    private void updateLists() {
        if (setStatus.getSelectedItem().toString() == "To Watch") {
            updateToWatch();
        } else if (setStatus.getSelectedItem().toString() == "Watching") {
            updateWatching();
        } else {
            updateWatched();
        }
    }

    // EFFECTS: Updates the "To Watch" list when a new to watch Movie has been added
    private void updateToWatch() {
        Object[] rowData = {nameMovie.getText(), "N/A"};
        WatchlistDisplay.getToWatchData().addRow(rowData);
    }

    // EFFECTS: Updates the "Watching" list when a new watching Movie has been added
    private void updateWatching() {
        Object[] rowData = {nameMovie.getText(), "N/A"};
        WatchlistDisplay.getWatchingData().addRow(rowData);
    }

    // EFFECTS: Updates the "Watched" list when a new watched Movie has been added
    private void updateWatched() {
        Object[] rowData = {nameMovie.getText(), "N/A", rating.getSelectedItem()};
        WatchlistDisplay.getWatchedData().addRow(rowData);
    }

    // EFFECTS: Closes the frame
    private void setCancelButton() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
}
