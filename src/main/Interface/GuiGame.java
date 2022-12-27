package Interface;

import DataStructure.Board;
import DataStructure.Player;
import Exceptions.InvalidHeight;
import Exceptions.InvalidWidth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class GuiGame extends GuiTemplate{

    public GuiGame(Player playerOne, Player playerTwo) {
        this.add(new Board(),BorderLayout.CENTER);
        this.add(new PanelInfos(playerOne, playerTwo),BorderLayout.EAST);
        this.setVisible(true);
            }

//    public static void main(String[] args) {
//        GuiGame game = new GuiGame();
//    }
}
