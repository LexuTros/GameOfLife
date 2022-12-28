package Interface;

import DataStructure.Board;
import DataStructure.Player;
import Logic.Gameplay;

import java.awt.*;



public class GuiGame extends GuiTemplate{

    public GuiGame(Board board, Player playerOne, Player playerTwo, Player activePlayer) {
        this.add(board,BorderLayout.CENTER);
        this.add(new PanelInfos(playerOne, playerTwo, activePlayer),BorderLayout.EAST);
        this.setVisible(true);
    }
}
