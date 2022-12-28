package Interface;

import DataStructure.Board;
import DataStructure.Player;

import java.awt.*;



public class GuiGame extends GuiTemplate{

    public GuiGame(Player playerOne, Player playerTwo, Player activePlayer) {
        this.add(new Board(),BorderLayout.CENTER);
        this.add(new PanelInfos(playerOne, playerTwo, activePlayer),BorderLayout.EAST);
        this.setVisible(true);
    }
}
