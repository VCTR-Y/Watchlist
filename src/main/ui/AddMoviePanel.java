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
    private JComboBox comboBox2;
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
        comboBox2.setEnabled(false);
    }

    private void setAddMovieButton(WatchLists watchlist) {
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = new Movie(String.valueOf(nameMovie), setStatus());
                watchlist.addMovie(movie);
            }
        });
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
