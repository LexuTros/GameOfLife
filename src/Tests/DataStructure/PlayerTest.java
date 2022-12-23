package Tests.DataStructure;

import static org.junit.jupiter.api.Assertions.*;

import DataStructure.Color;
import DataStructure.Player;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testGetPlayerName() {
        Player p = new Player("Philipp", "blue");
        assertEquals("Philipp", p.getPlayerName());
        assertTrue(p.getPlayerName().length() > 0);
        assertTrue(p.getPlayerName().length() <= 18);


    }

    @Test
    public void testGetPlayerColor() {
        Player p = new Player("Johnny", "green");
        assertEquals(Color.GREEN, p.getPlayerColor());
    }

    @Test
    public void testGetPlayerAliveCells() {
        Player p = new Player("Mark", "red");
        assertEquals(0, p.getAliveCells());
    }

    @Test
    public void testGetAliveCells() {
        Player p = new Player("Carl", "orange");
        p.setAliveCells(5);
        assertEquals(5, p.getAliveCells());
    }

    @Test
    public void testGetIsAlive() {
        Player p = new Player("Chris", "gray");
        p.setAliveCells(5);
        assertTrue(p.isAlive());
        p.setAliveCells(-5);
        assertFalse(p.isAlive());
    }
}
