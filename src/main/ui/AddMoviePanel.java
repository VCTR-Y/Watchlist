package ui;

import model.Movie;
import model.Status;
import model.WatchLists;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMoviePanel {
    private JFrame frame;
    private JPanel panel1;
    private JComboBox setStatus;
    private JComboBox rating;
    private JButton cancelButton;
    private JButton addMovieButton;
    private JTextField nameMovie;

    public AddMoviePanel(WatchLists watchlist) {
        frame = new JFrame();
        frame.add(panel1);
        setButtons(watchlist);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        // WANT TO BE ABLE TO MAKE COMBOBOX2 DISABLED WHEN NOT WATCHED
    }

    // NOT SURE IF THIS WORKS
    private Status setStatus() {
        if (setStatus.getSelectedItem().toString() == "To Watch") {
            return Status.TO_WATCH;
        } else if (setStatus.getSelectedItem().toString() == "Watching") {
            return Status.WATCHING;
        } else {
            return Status.WATCHED;
        }
    }

    private void setButtons(WatchLists watchlist) {
        setAddMovieButton(watchlist);
        setCancelButton();
    }

    private void setAddMovieButton(WatchLists watchlist) {
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameMovie.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter All Data");
                } else {
                    Movie movie = new Movie(nameMovie.getText(), setStatus());
                    watchlist.addMovie(movie);
                    updateLists();
                    frame.setVisible(false);
                }
            }
        });
    }

    private void updateLists() {
        if (setStatus.getSelectedItem().toString() == "To Watch") {
            updateToWatch();
        } else if (setStatus.getSelectedItem().toString() == "Watching") {
            updateWatching();
        } else {
            updateWatched();
        }
    }

    private void updateToWatch() {
        Object rowData[] = {nameMovie.getText(), "N/A"};
        WatchlistDisplay.getModel1().addRow(rowData);
    }

    private void updateWatching() {
        Object rowData[] = {nameMovie.getText(), "N/A"};
        WatchlistDisplay.getModel2().addRow(rowData);
    }

    private void updateWatched() {
        Object rowData[] = {nameMovie.getText(), "N/A", rating.getSelectedItem()};
        WatchlistDisplay.getModel3().addRow(rowData);
    }

    private void setCancelButton() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

}
