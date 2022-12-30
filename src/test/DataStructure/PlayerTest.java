package DataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

public class PlayerTest {
    @Test
    public void getPlayerNameTest() {
        Player p = new Player("Philipp", Color.GREEN);
        assertEquals("Philipp", p.getPlayerName());
        assertTrue(p.getPlayerName().length() > 0);
        assertTrue(p.getPlayerName().length() <= 18);
    }

    @Test
    public void getPlayerColorTest() {
        Player p = new Player("Johnny", Color.GREEN);
        assertEquals(Color.GREEN, p.getPlayerColor());
    }

    @Test
    public void getPlayerAliveCellsTest() {
        Player p = new Player("Mark", Color.RED);
        assertEquals(0, p.getAliveCells());
    }

    @Test
    public void getAliveCellsTest() {
        Player p = new Player("Carl", Color.ORANGE);
        p.setAliveCells(5);
        assertEquals(5, p.getAliveCells());
    }

    @Test
    public void getIsAliveTest() {
        Player p = new Player("Chris", Color.GRAY);
        p.setAliveCells(5);
        assertTrue(p.isAlive());
        p.setAliveCells(-5);
        assertFalse(p.isAlive());
    }
}
