package ui;

import model.Show;
import model.Status;
import model.WatchLists;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A frame that lets the user add a show
public class AddShowFrame {

    private JFrame frame;
    private JPanel panel1;
    private JTextField nameShow;
    private JComboBox setStatus;
    private JComboBox rating;
    private JButton cancelButton;
    private JButton addShowButton;
    private JTextField episodes;
    private JTextField episodesWatched;

    // EFFECTS: Creates a new AddShowFrame
    public AddShowFrame(WatchLists watchlist) {
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
        setAddShowButton(watchlist);
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

    // EFFECTS: Sets functionality to the Add Show button
    private void setAddShowButton(WatchLists watchlist) {
        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isBlank()) {
                    JOptionPane.showMessageDialog(null, "Please Enter All Data");
                } else if (!(isNumeric(episodes.getText(), episodesWatched.getText()))) {
                    JOptionPane.showMessageDialog(null, "Episodes and/or Episodes Watched Must be a Number");
                } else if (Integer.parseInt(episodes.getText()) < Integer.parseInt(episodesWatched.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Can't Have More Episodes Watched Than Episodes");
                } else if (noRating()) {
                    JOptionPane.showMessageDialog(null, "Please Give A Rating");
                } else {
                    Show show = new Show(nameShow.getText(), Integer.parseInt(episodes.getText()),
                            Integer.parseInt(episodesWatched.getText()), setStatus());
                    if (setStatus.getSelectedItem().toString() == "Watched") {
                        show.changeShowRating(Integer.parseInt(rating.getSelectedItem().toString()));
                    }
                    watchlist.addShow(show);
                    updateLists();
                }
            }
        });
    }

    // EFFECTS: Checks if episodes and episodes watched is an int
    private boolean isNumeric(String ep, String epw) {
        try {
            Integer.parseInt(ep);
            Integer.parseInt(epw);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // EFFECTS: Checks if any text field is left blank
    private boolean isBlank() {
        if (nameShow.getText().equals("") || episodes.getText().equals("") || episodesWatched.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: Checks if a rating is given when a show is Watched
    private boolean noRating() {
        if (rating.getSelectedItem().toString() == "N/A" && setStatus.getSelectedItem().toString() == "Watched") {
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: Updates the WatchList when a new Show has been added
    private void updateLists() {
        if (setStatus.getSelectedItem().toString() == "To Watch") {
            updateToWatch();
            frame.setVisible(false);
        } else if (setStatus.getSelectedItem().toString() == "Watching") {
            updateWatching();
            frame.setVisible(false);
        } else {
            updateWatched();
            frame.setVisible(false);
        }
    }

    // EFFECTS: Updates the "To Watch" list when a new to watch Show has been added
    private void updateToWatch() {
        Object[] rowData = {nameShow.getText(), "0/" + episodes.getText()};
        WatchlistDisplay.getToWatchData().addRow(rowData);
    }

    // EFFECTS: Updates the "Watching" list when a new watching Show has been added
    private void updateWatching() {
        Object[] rowData = {nameShow.getText(), episodesWatched.getText() + "/" + episodes.getText()};
        WatchlistDisplay.getWatchingData().addRow(rowData);
    }

    // EFFECTS: Updates the "Watched" list when a new watched Show has been added
    private void updateWatched() {
        Object[] rowData = {nameShow.getText(), episodes.getText()
                + "/" + episodes.getText(), rating.getSelectedItem()};
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
