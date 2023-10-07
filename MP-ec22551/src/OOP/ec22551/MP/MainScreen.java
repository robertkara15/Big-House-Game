package OOP.ec22551.MP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame
{
    JPanel mainPanel;
    private JScrollPane gameLogScrollPane;
    private JTextArea userTextArea;
    private JScrollPane inventoryScrollPane;
    private JButton northButton;
    private JButton eastButton;
    private JButton southButton;
    private JButton westButton;
    private JButton yesButton;
    private JButton noButton;
    private JTextArea currentFloorTextArea;
    private JTextArea goldTextArea;
    private JTextArea currentRoomTextArea;
    private JTextArea gameLogTextArea;
    private JTextArea inventoryTextArea;
    private JLabel gameLogLabel;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JLabel minimap;
    private JLabel uniqueItemsMessage;

    public MainScreen()
    {
        // GUI layout stuff
        setTitle("MP BY EC22551");
        setSize(1000,700);
        setContentPane(mainPanel);
        setResizable(false);
        setVisible(false);
        setLocationRelativeTo(null);

        gameLogTextArea.setWrapStyleWord(true);
        gameLogTextArea.setLineWrap(true);
        gameLogScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gameLogTextArea.setCaretPosition(gameLogTextArea.getDocument().getLength());


        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        westButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JTextArea getGameLogTextArea()
    {
        return gameLogTextArea;
    }
    public JTextArea getCurrentFloorTextArea()
    {
        return currentFloorTextArea;
    }
    public JTextArea getCurrentRoomTextArea()
    {
        return currentRoomTextArea;
    }
    public JTextArea getUserTextArea()
    {
        return userTextArea;
    }
    public JTextArea getGoldTextArea()
    {
        return goldTextArea;
    }
    public JTextArea getInventoryTextArea()
    {
        return inventoryTextArea;
    }
    public JButton getOneButton()
    {
        return oneButton;
    }
    public JButton getTwoButton()
    {
        return twoButton;
    }
    public JButton getThreeButton()
    {
        return threeButton;
    }
    public JButton getFourButton()
    {
        return fourButton;
    }
    public JButton getYesButton()
    {
        return yesButton;
    }
    public JButton getNoButton()
    {
        return noButton;
    }
    public JButton getNorthButton()
    {
        return northButton;
    }
    public JButton getEastButton()
    {
        return eastButton;
    }
    public JButton getSouthButton()
    {
        return southButton;
    }
    public JButton getWestButton()
    {
        return westButton;
    }
    public JLabel getMinimap(){return minimap;}
    public JLabel getUniqueItemsMessage(){return uniqueItemsMessage;}
    public JPanel getMainPanel(){return mainPanel;}
}
