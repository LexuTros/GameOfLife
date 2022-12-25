package Logic;

import DataStructure.Color;
import DataStructure.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private final Game g = new Game();

    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }



    @Test
    public void testGetPlayerName() {
        String input = "Johnny\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        String name = g.getPlayerName();
        assertEquals("Johnny", name);
    }



    @Test
    public void testGetValidPlayerColor() {
        String input = "blue\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String color = g.getPlayerColor(null);
        assertTrue(Arrays.asList(Color.values()).contains(Color.valueOf(color.toUpperCase())));
    }

    @Test
    public void testContainsColors() {
        String input = "pink\nblue\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String color = g.getPlayerColor(null);
        assertTrue(Arrays.asList(Color.values()).contains(Color.valueOf(color.toUpperCase())));
    }

    @Test
    public void testGetSamePlayerColors() {
        Player p = new Player("Chris", "red");
        String input = "red\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(NoSuchElementException.class, () -> g.getPlayerColor(p));
    }

    @Test
    public void testGetBoardSizeValid() {
            String input = "50\n50";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ArrayList<Integer> testBoard = g.getBoardSize();
            assertEquals(2, testBoard.size());
            assertEquals(50, testBoard.get(0));
            assertEquals(50, testBoard.get(1));
    }

    @Test
    public void testGetBoardSizeInvalid() {
        String input = "30\n50";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        assertThrows(NoSuchElementException.class, () -> g.getBoardSize());
    }

    @Test
    public void testAskForNewGameYes() {
        String input = "yes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean result = g.askForNewGame();
        assertTrue(result);
    }

    @Test
    public void testAskForNewGameNo() {
        String input = "no\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean result = g.askForNewGame();
        assertFalse(result);
    }




}












