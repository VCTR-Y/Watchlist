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
    private JTextField showName;
    private JComboBox setStatus;
    private JComboBox comboBox2;
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
        if (String.valueOf(setStatus) == "To Watch") {
            return Status.TO_WATCH;
        } else if (String.valueOf(setStatus) == "Watching") {
            return Status.WATCHING;
        } else {
            return Status.WATCHED;
        }
    }

    private void setButtons(WatchLists watchlist) {
        setAddShowButton(watchlist);
        setCancelButton();
        comboBox2.setEnabled(false);

//        I want to make it so it only enables this combobox if the other combobox has a certain value selected

//        if (String.valueOf(setStatus) == "Watched") {
//            comboBox2.setEnabled(true);
        }

    private void setAddShowButton(WatchLists watchList) {
        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Show show = new Show(String.valueOf(showName), Integer.parseInt(String.valueOf(episodes)),
                        Integer.parseInt(String.valueOf(episodesWatched)), setStatus());
                watchList.addShow(show);
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
}
