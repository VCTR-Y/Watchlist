package ui;

import model.Movie;
import model.Show;
import model.WatchLists;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WatchlistDisplay {

    private static final String JSON_STORE = "./data/watchlist.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    private JFrame mainFrame;
    private WatchLists watchlist;

    private AddMovieFrame addMovieFrame;
    private AddShowFrame addShowFrame;

    private JPanel watchlistUI;

    private JTable toWatchList;
    private JTable watchingList;
    private JTable watchedList;
    private static DefaultTableModel toWatchData;
    private static DefaultTableModel watchingData;
    private static DefaultTableModel watchedData;

    private JButton addMovieButton;
    private JButton addShowButton;
    private JButton removeButton;
    private JButton saveButton;
    private JButton loadButton;

    // EFFECTS: Creates a new WatchlistDisplay()
    public WatchlistDisplay() {
        watchlist = new WatchLists();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        mainFrame = new JFrame("WatchList");
        mainFrame.add(watchlistUI);
        createWatchList();
        setButtons();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    // EFFECTS: Creates the watchlists displayed on screen
    private void createWatchList() {
        createToWatchList();
        createWatchingList();
        createWatchedList();
    }

    // EFFECTS: Creates the toWatchList JTable
    private void createToWatchList() {
        toWatchList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes"}));
        toWatchData = (DefaultTableModel) toWatchList.getModel();
    }

    // EFFECTS: Creates the watchingList JTable
    private void createWatchingList() {
        watchingList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes"}));
        watchingData = (DefaultTableModel) watchingList.getModel();
    }

    // EFFECTS: Creates the watchedList JTable
    private void createWatchedList() {
        watchedList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes", "Rating"}));
        watchedData = (DefaultTableModel) watchedList.getModel();
    }

    // EFFECTS: Sets the functionalities of AddMovieButton, AddShowButton, RemoveMovieShowButton,
    //          SaveButton, and LoadButton
    private void setButtons() {
        setAddMovieButton();
        setAddShowButton();
        setRemoveMovieShowButton();
        setSaveButton();
        setLoadButton();
    }

    // EFFECTS: Opens a new AddMovieFrame
    private void setAddMovieButton() {
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMovieFrame = new AddMovieFrame(watchlist);
            }
        });
    }

    // EFFECTS: Opens a new AddShowFrame
    private void setAddShowButton() {
        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShowFrame = new AddShowFrame(watchlist);
            }
        });
    }

    // EFFECTS: Removes the selected movie or show
    private void setRemoveMovieShowButton() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toWatchList.getSelectedRow() >= 0) {
                    watchlist.getToWatchList().remove(toWatchList.getSelectedRow());
                    toWatchData.removeRow(toWatchList.getSelectedRow());
                } else if (watchingList.getSelectedRow() >= 0) {
                    watchlist.getWatchingList().remove(watchingList.getSelectedRow());
                    watchingData.removeRow(watchingList.getSelectedRow());
                } else if (watchedList.getSelectedRow() >= 0) {
                    watchlist.getWatchedList().remove(watchedList.getSelectedRow());
                    watchedData.removeRow(watchedList.getSelectedRow());
                } else {
                    JOptionPane.showMessageDialog(null, "Select a Movie/Show to delete");
                }
            }
        });
    }

    // EFFECTS: Saves the data in the application
    private void setSaveButton() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(watchlist);
                    jsonWriter.close();
                    JOptionPane.showMessageDialog(null, "Successfully Saved");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong...");
                }
            }
        });
    }

    // EFFECTS: Loads the saved data in the application
    private void setLoadButton() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    watchlist = jsonReader.read();
                    loadToWatch();
                    loadWatching();
                    loadWatched();
                    JOptionPane.showMessageDialog(null, "Successfully Loaded");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong...");
                }
            }
        });
    }

    // EFFECTS: Loads data in the To Watch list
    private void loadToWatch() {
        Object[] rowData = new Object[2];
        for (int i = 0; i < watchlist.getToWatchList().size(); i++) {
            if (watchlist.getToWatchList().get(i) instanceof Movie) {
                rowData[0] = ((Movie) watchlist.getToWatchList().get(i)).getMovieName();
                rowData[1] = "N/A";
                toWatchData.addRow(rowData);
            } else if (watchlist.getToWatchList().get(i) instanceof Show) {
                rowData[0] = ((Show) watchlist.getToWatchList().get(i)).getShowName();
                rowData[1] = "0/" + ((Show) watchlist.getToWatchList().get(i)).getShowEpisodes();
                toWatchData.addRow(rowData);
            }
        }
    }

    // EFFECTS: Loads the data in the Watching list
    private void loadWatching() {
        Object[] rowData = new Object[2];
        for (int i = 0; i < watchlist.getWatchingList().size(); i++) {
            if (watchlist.getWatchingList().get(i) instanceof Movie) {
                rowData[0] = ((Movie) watchlist.getWatchingList().get(i)).getMovieName();
                rowData[1] = "N/A";
                watchingData.addRow(rowData);
            } else if (watchlist.getWatchingList().get(i) instanceof Show) {
                rowData[0] = ((Show) watchlist.getWatchingList().get(i)).getShowName();
                rowData[1] = ((Show) watchlist.getWatchingList().get(i)).getShowEpisodesWatched()
                        + "/" + ((Show) watchlist.getWatchingList().get(i)).getShowEpisodes();
                watchingData.addRow(rowData);
            }
        }
    }

    // EFFECTS: Loads the data in the Watched list
    private void loadWatched() {
        Object[] rowData = new Object[3];
        for (int i = 0; i < watchlist.getWatchedList().size(); i++) {
            if (watchlist.getWatchedList().get(i) instanceof Movie) {
                rowData[0] = ((Movie) watchlist.getWatchedList().get(i)).getMovieName();
                rowData[1] = "N/A";
                rowData[2] = ((Movie) watchlist.getWatchedList().get(i)).getMovieRating();
                watchedData.addRow(rowData);
            } else if (watchlist.getWatchedList().get(i) instanceof Show) {
                rowData[0] = ((Show) watchlist.getWatchedList().get(i)).getShowName();
                rowData[1] = ((Show) watchlist.getWatchedList().get(i)).getShowEpisodes()
                        + "/" + ((Show) watchlist.getWatchedList().get(i)).getShowEpisodes();
                rowData[2] = ((Show) watchlist.getWatchedList().get(i)).getShowRating();
                watchedData.addRow(rowData);
            }
        }
    }

    // EFFECTS: Gets toWatchData
    public static DefaultTableModel getToWatchData() {
        return toWatchData;
    }

    // EFFECTS: Gets watchingData
    public static DefaultTableModel getWatchingData() {
        return watchingData;
    }

    // EFFECTS: Gets watchedData
    public static DefaultTableModel getWatchedData() {
        return watchedData;
    }
}
