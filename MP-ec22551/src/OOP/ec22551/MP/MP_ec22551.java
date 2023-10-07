package OOP.ec22551.MP;

import javax.swing.*;

public abstract class MP_ec22551
{
    static StartScreen start = new StartScreen();
    static MainScreen frame = new MainScreen();


    public static void main(String[] args)
    {
        Visitable h = new House_ec22551();
        Visitor v = new GUIVisitor(System.out,System.in);
        h.visit(v, Direction.FROM_SOUTH);
    }
}
