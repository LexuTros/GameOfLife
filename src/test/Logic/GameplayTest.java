package Logic;

import static org.junit.jupiter.api.Assertions.*;

import DataStructure.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GameplayTest {
    @Test
    public void getActivePlayerTest() {
        Gameplay.activePlayer = Gameplay.player1;
        assertEquals(Gameplay.player1, Gameplay.getActivePlayer());
    }

    @Test
    public void getGenerationTest() {

        Gameplay.generation = 10;
        assertEquals(10, Gameplay.getGeneration());
    }

    @Test
    public void getToKillTest() {
        Gameplay.toKill = true;
        assertTrue(Gameplay.getToKill());

        Gameplay.toKill = false;
        assertFalse(Gameplay.getToKill());
    }

    @Test
    public void setToKillTest() {
        assertFalse(Gameplay.toKill);
        Gameplay.setToKill(true);
        assertTrue(Gameplay.toKill);
    }

    @Test
    public void getToCreateTest() {
        Gameplay.toCreate = true;
        assertTrue(Gameplay.getToCreate());
    }

    @Test
    public void setToCreateTest() {
        Gameplay.setToCreate(true);
        assertTrue(Gameplay.toCreate);
    }

    @Test
    public void getStartingPlayerTest() {
        Player p1 = new Player("Johnny", Color.GREEN);
        Player p2 = new Player("Chris", Color.PINK);

        Gameplay.player1 = p1;
        Gameplay.player2 = p2;

        Gameplay.getStartingPlayer();
        assertEquals(p2, Gameplay.activePlayer);

        Gameplay.player1 = p2;
        Gameplay.player2 = p1;

        Gameplay.getStartingPlayer();
        assertNotEquals(p2, Gameplay.activePlayer);

    }

}
