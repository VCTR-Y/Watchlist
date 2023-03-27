package ui;

import model.WatchLists;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchlistDisplay {

    private static final String JSON_STORE = "./data/watchlist.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    private JFrame mainFrame;
    private WatchLists watchlist;

    private AddMoviePanel addMovieFrame;
    private AddShowPanel addShowFrame;

    private JPanel watchlistUI;
    private JTable toWatchList;
    private JTable watchingList;
    private JTable watchedList;
    private JButton addMovieButton;
    private JButton addShowButton;
    private JButton removeButton;
    private JButton saveButton;
    private JButton loadButton;

    public WatchlistDisplay() {
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        mainFrame = new JFrame("WatchList");
        mainFrame.add(watchlistUI);
        createWatchList();
        setButtons();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
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

    private void setButtons() {
        setAddMovieButton();
        setAddShowButton();
        setRemoveMovieShowButton();
        setSaveButton();
        setLoadButton();
    }

    private void setAddMovieButton() {
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMovieFrame = new AddMoviePanel(watchlist);
            }
        });
    }

    private void setAddShowButton() {
        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShowFrame = new AddShowPanel(watchlist);
            }
        });
    }

    private void setRemoveMovieShowButton() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void setSaveButton() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void setLoadButton() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
