package Interface;

import DataStructure.Board;
import DataStructure.Player;

import java.awt.*;



public class GuiGame extends GuiTemplate{

    public GuiGame(Player playerOne, Player playerTwo) {
        this.add(new Board(),BorderLayout.CENTER);
        this.add(new PanelInfos(playerOne, playerTwo),BorderLayout.EAST);
        this.setVisible(true);
    }
}
