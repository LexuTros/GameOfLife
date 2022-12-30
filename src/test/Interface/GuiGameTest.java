package Interface;

import Logic.Gameplay;
import org.junit.jupiter.api.Test;
import DataStructure.Board;
import DataStructure.Player;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GuiGameTest {

    Board board = new Board(50, 50);
    Player p1 = new Player("Philipp", Color.GREEN);
    Player p2 = new Player("Johnny", Color.PINK);
    Player activePlayer = p1;

    @Test
    public void constructorTest() {
        Gameplay.setActivePlayer(p1);
        GuiGame guiGame = new GuiGame(board, p1, p2, activePlayer);

        assertNotNull(guiGame);
    }

}
