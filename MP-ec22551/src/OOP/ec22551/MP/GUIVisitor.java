package OOP.ec22551.MP;

import com.sun.source.tree.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;

class GUIVisitor implements Visitor {

    private static MainScreen mainScreen = MP_ec22551.frame;
    private static StartScreen startScreen = MP_ec22551.start;
    private PrintStream out;
    private Scanner in;
    private int purse;
    private Item[] items;
    protected HashMap<Integer,Item> inventory;
    protected Set<String> itemNames;
    private int next;

    public GUIVisitor(PrintStream ps, InputStream is)
    {
        out = ps;
        in = new Scanner(is);
        purse = 0;
        items = new Item[1000];
        inventory = new HashMap<Integer, Item>();
        itemNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        next = 1;
    }

    private static final char[] yOrN = { 'y', 'n'};
   
    public void tell(String m)
    {
        mainScreen.getGameLogTextArea().append(m + "\n");
    }

    // updates the current floor text area
    public void updateFloor(String f)
    {
        mainScreen.getCurrentFloorTextArea().setText(f);
    }

    // updates the current room text area
    public void updateRoom(String r)
    {
        mainScreen.getCurrentRoomTextArea().setText(r);
    }

    // updates the image in the minimap label
    public void updateMinimap(String m)
    {
        if(Objects.equals(m, "816"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/816.png"));
        }
        else if(Objects.equals(m, "elevator"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/elevator.jpg"));
        }
        else if(Objects.equals(m, "foyer"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/foyer.jpg"));
        }
        else if(Objects.equals(m, "room1"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/room1.jpg"));
        }
        else if(Objects.equals(m, "room2"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/room2.jpg"));
        }
        else if(Objects.equals(m, "room3"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/room3.jpg"));
        }
        else if(Objects.equals(m, "stairs"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/stairs.jpg"));
        }
        else if(Objects.equals(m, "basement"))
        {
            mainScreen.getMinimap().setIcon(new ImageIcon("src/OOP/ec22551/MP/images/basement.jpg"));
        }
    }

    // updates the current background colour
    public void updateBackground(String m)
    {
        if(Objects.equals(m, "816"))
        {
            mainScreen.getMainPanel().setBackground(new Color(255, 244, 0));
        }
        else if(Objects.equals(m, "elevator"))
        {
            mainScreen.getMainPanel().setBackground(new Color(124, 118, 114));
        }
        else if(Objects.equals(m, "foyer"))
        {
            mainScreen.getMainPanel().setBackground(new Color(188,138,92));
        }
        else if(Objects.equals(m, "room1"))
        {
            mainScreen.getMainPanel().setBackground(new Color(255, 255, 255));
        }
        else if(Objects.equals(m, "room2"))
        {
            mainScreen.getMainPanel().setBackground(new Color(252, 129, 13));
        }
        else if(Objects.equals(m, "room3"))
        {
            mainScreen.getMainPanel().setBackground(new Color(200, 196, 255));
        }
        else if(Objects.equals(m, "stairs"))
        {
            mainScreen.getMainPanel().setBackground(new Color(131, 124, 116));
        }
        else if(Objects.equals(m, "basement"))
        {
            mainScreen.getMainPanel().setBackground(new Color(124, 48, 48));
        }
    }

    // getChoice now only considers the necessary buttons
    public char getChoice(String d, char[] a) {
        tell(d);

        boolean[] buttonPressed = new boolean[1];
        buttonPressed[0] = false;
        char[] returnChar = new char[1];

        // means the necessary buttons are 1,2,3,4
        if (a[0] == '1')
        {
            try
            {
                while (!buttonPressed[0])
                {
                    mainScreen.getOneButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getOneButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                    mainScreen.getTwoButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getTwoButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                    mainScreen.getThreeButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getThreeButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                    mainScreen.getFourButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getFourButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                }
            }
            catch (NullPointerException e)
            {
                tell("ERROR: INVALID BUTTON PRESSED");
            }
        }

        // means the necessary buttons are y,n
        else if (a[0] == 'y')
        {
            try
            {
                while (!buttonPressed[0])
                {
                    mainScreen.getYesButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getYesButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                    mainScreen.getNoButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getNoButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                }
            }
            catch (NullPointerException e)
            {
                tell("ERROR: INVALID BUTTON PRESSED");
            }
        }

        // means the necessary buttons are N,E,S,W
        else if (a[0] == 'N')
        {
            try
            {
                while (!buttonPressed[0])
                {
                    mainScreen.getNorthButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getNorthButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                    mainScreen.getEastButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getEastButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                    mainScreen.getSouthButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getSouthButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                    mainScreen.getWestButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returnChar[0] = mainScreen.getWestButton().getText().charAt(0);
                            buttonPressed[0] = true;
                        }
                    });
                }
            }
            catch (NullPointerException e)
            {
                tell("ERROR: INVALID BUTTON PRESSED");
            }
        }


        return returnChar[0];
    }
    
    public boolean giveItem(Item x) {
        for (int i=0;i<next;i++) out.print(inventory.get(i) + ", ");
        tell("You are being offered: "+x.name);
        if (getChoice("Do you accept (y/n)?", yOrN) == 'y') {
            inventory.put(next,x);
            itemNames.add(inventory.get(next).name);
            mainScreen.getUniqueItemsMessage().setText("You have " + (itemNames.size()) + " unique item(s)");
            mainScreen.getInventoryTextArea().append("Item " + (next) + ": " + inventory.get(next).name + "\n");
            next++;

            return true;
        } else return false;
    }


    
    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++) 
            if (x == inventory.get(i))
                return true;
        return false;
    }
        
    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++)
            if (x == inventory.get(i))
                return true;
        return false;
    }
    
    public void giveGold(int n) {
        tell("You are given "+n+" gold pieces.");
        purse += n;
        mainScreen.getGoldTextArea().setText(String.valueOf(purse));
        tell("You now have "+purse+" pieces of gold.");
    }
        
    public int takeGold(int n) {
        
        if (n<0) {
            tell("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            tell("but you didn't fall for it and returned the 'loan'.");
            return 0;
        }
        
        int t = 0;
        if (n > purse) t = purse;
        else t = n;

        tell(t+" pieces of gold are taken from you.");
        purse -= t;
        tell("You now have "+purse+" pieces of gold.");

        mainScreen.getGoldTextArea().setText(String.valueOf(purse));
        return t;
    }
}
