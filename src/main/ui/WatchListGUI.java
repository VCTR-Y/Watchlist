package ui;

import model.WatchLists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchListGUI {

    private WatchLists watchlist;
    private JFrame frame;
    private JPanel mainPanel;
    private JButton viewButton;
    private JButton nullButton;
    private JButton saveButton;
    private JButton loadButton;

    public WatchListGUI() {
        watchlist = new WatchLists();

        frame = new JFrame("Watchlist");
        mainPanel = new JPanel();
        viewButton = new JButton("View Watchlist");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
            }
        });
        nullButton = new JButton("(blank)");
        nullButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
            }
        });
        saveButton = new JButton("Save Watchlist");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // stub
            }
        });
        loadButton = new JButton("Load Watchlist");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // stub
            }
        });

        mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        mainPanel.setLayout(new GridLayout());
        mainPanel.add(viewButton);
        mainPanel.add(nullButton);
        mainPanel.add(saveButton);
        mainPanel.add(loadButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
