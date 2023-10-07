package OOP.ec22551.MP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame {

    private JPanel startPanel;
    private ImageIcon startBackgroundImage;
    private JLabel bg;
    private JLabel text1;
    private JLabel text2;
    private JButton startButton;

    StartScreen()
    {
        // GUI layout stuff
        setSize(1000,700);
        setResizable(false);
        setTitle("The Big House");
        setLocationRelativeTo(null);

        // background image
        startBackgroundImage = new ImageIcon("src/OOP/ec22551/MP/images/theBigHouse.jpg");
        startButton = new JButton("START");
        bg = new JLabel(startBackgroundImage);
        bg.setBounds(0,0,1000,700);
        add(bg);

        // button
        startButton.setBounds(468,420,100,40);
        bg.add(startButton);
        startButton.setForeground(Color.BLACK);

        // title label
        text1 = new JLabel("THE BIG HOUSE");
        text1.setBounds(500,300,100,40);
        text1.setFont(new Font("Impact", Font.BOLD, 48));
        bg.add(text1);

        // other label
        text2 = new JLabel("Go BIG or go HOME but NEVER do both\n" +
                "        But what if you could???????\n" +
                "        WELCOME TO THE BIG HOUSE!! (bought to you by BIG Chocolate Bar™) \n" +
                "        Here we break all the rules \n" +
                "        You can go BIG and go (to a) HOME\n" +
                "        \n" +
                "        You do not even remember entering the BIG HOUSE\n" +
                "        All you remember is eating a BIG Chocolate Bar™ \n" +
                "        And somehow waking up inside the foyer of the BIG HOUSE");
        text2.setBounds(500,300,100,40);
        text2.setFont(new Font("Impact", Font.BOLD, 12));




        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame GUI = MP_ec22551.frame;
                GUI.setVisible(true);
                dispose(); // dispose the current frame
            }
        });
    }

    public static void main(String[] args) {

    }
}
