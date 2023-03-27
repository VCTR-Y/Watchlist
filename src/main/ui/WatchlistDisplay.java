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
    private static DefaultTableModel model1;
    private static DefaultTableModel model2;
    private static DefaultTableModel model3;

    private JButton addMovieButton;
    private JButton addShowButton;
    private JButton removeButton;
    private JButton saveButton;
    private JButton loadButton;

    public WatchlistDisplay() {
        watchlist = new WatchLists();
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
        model1 = (DefaultTableModel) toWatchList.getModel();
        Object rowData[] = new Object[2];
//        for (int i = 0; i < watchlist.getToWatchList().size(); i++) {
//            if (watchlist.getToWatchList().get(i) instanceof Movie) {
//                rowData[0] = ((Movie) watchlist.getToWatchList().get(i)).getMovieName();
//                rowData[1] = "N/A";
//                model1.addRow(rowData);
//            } else if (watchlist.getToWatchList().get(i) instanceof Show) {
//                rowData[0] = ((Show) watchlist.getToWatchList().get(i)).getShowName();
//                rowData[1] = "0/" + ((Show) watchlist.getToWatchList().get(i)).getShowEpisodes();
//                model1.addRow(rowData);
//            }
//        }
    }

    private void createWatchingList() {
        watchingList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes"}));
        model2 = (DefaultTableModel) watchingList.getModel();
        Object rowData[] = new Object[2];
//        for (int i = 0; i < watchlist.getWatchingList().size(); i++) {
//            if (watchlist.getWatchingList().get(i) instanceof Movie) {
//                rowData[0] = ((Movie) watchlist.getWatchingList().get(i)).getMovieName();
//                rowData[1] = "N/A";
//                model2.addRow(rowData);
//            } else if (watchlist.getWatchingList().get(i) instanceof Show) {
//                rowData[0] = ((Show) watchlist.getWatchingList().get(i)).getShowName();
//                rowData[1] = ((Show) watchlist.getWatchingList().get(i)).getShowEpisodesWatched()
//                        + "/" + ((Show) watchlist.getWatchingList().get(i)).getShowEpisodes();
//                model2.addRow(rowData);
//            }
//        }
    }

    private void createWatchedList() {
        watchedList.setModel(new DefaultTableModel(null, new String[]{"Name", "Episodes", "Rating"}));
        model3 = (DefaultTableModel) watchedList.getModel();
        Object rowData[] = new Object[3];
//        for (int i = 0; i < watchlist.getWatchedList().size(); i++) {
//            if (watchlist.getWatchedList().get(i) instanceof Movie) {
//                rowData[0] = ((Movie) watchlist.getWatchedList().get(i)).getMovieName();
//                rowData[1] = "N/A";
//                rowData[2] = ((Movie) watchlist.getWatchedList().get(i)).getMovieRating();
//            } else if (watchlist.getWatchedList().get(i) instanceof Show) {
//                rowData[0] = ((Show) watchlist.getWatchedList().get(i)).getShowName();
//                rowData[1] = ((Show) watchlist.getWatchedList().get(i)).getShowEpisodes()
//                        + "/" + ((Show) watchlist.getWatchedList().get(i)).getShowEpisodes();
//                rowData[2] = ((Show) watchlist.getWatchedList().get(i)).getShowRating();
//            }
//        }
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

    public static DefaultTableModel getModel1() {
        return model1;
    }

    public static DefaultTableModel getModel2() {
        return model2;
    }

    public static DefaultTableModel getModel3() {
        return model3;
    }
}
