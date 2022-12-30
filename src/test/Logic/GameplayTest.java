package Logic;

import static org.junit.jupiter.api.Assertions.*;

import DataStructure.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;
import static org.mockito.Mockito.*;

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
        Gameplay.setToKill(true);
        assertTrue(Gameplay.getToKill());

        Gameplay.setToKill(false);
        assertFalse(Gameplay.getToKill());
    }

    @Test
    public void setToKillTest() {
        assertFalse(Gameplay.getToKill());
        Gameplay.setToKill(true);
        assertTrue(Gameplay.getToKill());
    }

    @Test
    public void getToCreateTest() {
        Gameplay.setToCreate(true);
        assertTrue(Gameplay.getToCreate());
    }

    @Test
    public void setToCreateTest() {
        Gameplay.setToCreate(true);
        assertTrue(Gameplay.getToCreate());
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
        assertEquals(p2, Gameplay.activePlayer);

    }

    @Test
    public void mainTest() {
        Gameplay g = mock(Gameplay.class);
        Gameplay.main(new String[] {});
        verify(g).welcomeDisplay();

    }

}
