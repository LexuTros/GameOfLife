package DataStructure;

import javax.swing.*;
import java.awt.*;

public class Player extends JLabel {
    private String name;
    private Color color;
    private int aliveCells;


    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.aliveCells = 0;;

    }

    public void setAliveCells(int numberOfCells) {
        aliveCells += numberOfCells;
    }

    public int getAliveCells() {
        return this.aliveCells;
    }

    public String getPlayerName() {
        return name;
    }

    public Color getPlayerColor() {
        return color;
    }

    public boolean isAlive()
    {
        return getAliveCells() > 0;
    }

}
