package ui;

import model.Show;
import model.Status;
import model.WatchLists;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddShowPanel {

    private JFrame frame;
    private JPanel panel1;
    private JTextField nameShow;
    private JComboBox setStatus;
    private JComboBox rating;
    private JButton cancelButton;
    private JButton addShowButton;
    private JTextField episodes;
    private JTextField episodesWatched;

    public AddShowPanel(WatchLists watchlist) {
        frame = new JFrame();
        frame.add(panel1);
        setButtons(watchlist);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel1;
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
        setAddShowButton(watchlist);
        setCancelButton();
        rating.setEnabled(true);

//        I want to make it so it only enables this combobox if the other combobox has a certain value selected

//        if (String.valueOf(setStatus) == "Watched") {
//            comboBox2.setEnabled(true);
        }

    private void setAddShowButton(WatchLists watchlist) {
        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameShow.getText().equals("") || episodes.getText().equals("") || episodesWatched.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all data");
                } else if (Integer.parseInt(episodes.getText()) < Integer.parseInt(episodesWatched.getText())) {
                    JOptionPane.showMessageDialog(null, "Can't have more episodes watched than episodes");
                } else {
                    Show show = new Show(String.valueOf(nameShow), Integer.parseInt(episodes.getText()),
                            Integer.parseInt(episodesWatched.getText()), setStatus());
                    watchlist.addShow(show);
                    updateLists();
                    frame.setVisible(false);
                }
            }
        });
    }

    private void updateLists(){
        if (setStatus.getSelectedItem().toString() == "To Watch") {
            updateToWatch();
        } else if (setStatus.getSelectedItem().toString() == "Watching") {
            updateWatching();
        } else {
            updateWatched();
        }
    }

    private void updateToWatch() {
        Object rowData[] = {nameShow.getText(), "0/" + episodes.getText()};
        WatchlistDisplay.getModel1().addRow(rowData);
    }

    private void updateWatching() {
        Object rowData[] = {nameShow.getText(), episodesWatched.getText() + "/" + episodes.getText()};
        WatchlistDisplay.getModel2().addRow(rowData);
    }

    private void updateWatched() {
        Object rowData[] = {nameShow.getText(), episodes.getText() + "/" + episodes.getText(), rating.getSelectedItem()};
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
}
