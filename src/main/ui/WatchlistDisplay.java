package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchlistDisplay {

    private JFrame frame;
    private JPanel watchlistUI;
    private AddMoviePanel addMovie;
    private AddShowPanel addShow;
    private JTable toWatchList;
    private JTable watchingList;
    private JTable watchedList;
    private JButton addMovieButton;
    private JButton addShowButton;
    private JButton saveButton;
    private JButton loadButton;

    public WatchlistDisplay() {
        frame = new JFrame("WatchList");
        frame.add(watchlistUI);
        createWatchList();
        setAddMovieButton();
        setAddShowButton();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void createWatchList() {
        createToWatchList();
        createWatchingList();
        createWatchedList();
    }
    private void createToWatchList() {
        toWatchList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes"}));
    }

    private void createWatchingList() {
        watchingList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes"}));
    }

    private void createWatchedList() {
        watchedList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes", "Rating"}));
    }

    private void setAddMovieButton() {
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void setAddShowButton() {
        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
