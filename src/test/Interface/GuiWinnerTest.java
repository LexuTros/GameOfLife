package Interface;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GuiWinnerTest {
    @Test
    public void constructorTest() {
        GuiWinner guiWinner = new GuiWinner("Player 1");
        assertNotNull(guiWinner.labelWin);
        assertEquals("CONGRATULATIONS", guiWinner.labelWin.getText());
        assertEquals(new Font("Papyrus", Font.BOLD, 60), guiWinner.labelWin.getFont());
        assertEquals(new Rectangle(120, 200, 1000, 100), guiWinner.labelWin.getBounds());

        assertNotNull(guiWinner.labelWin);
        assertEquals("Player 1", guiWinner.labelWinner.getText());
        assertEquals(new Font("Papyrus", Font.BOLD, 80), guiWinner.labelWinner.getFont());
        assertNotNull(guiWinner.labelWinner);
        assertEquals("Player 1", guiWinner.labelWinner.getText());
        assertEquals(new Font("Papyrus", Font.BOLD, 80), guiWinner.labelWinner.getFont());
        assertEquals(new Rectangle(240, 300, 1000, 100), guiWinner.labelWinner.getBounds());

        assertNotNull(guiWinner.buttonBackToBoard);
        assertEquals("Back to Board", guiWinner.buttonBackToBoard.getText());
        assertEquals(new Rectangle(280, 600, 200, 60), guiWinner.buttonBackToBoard.getBounds());

        assertNotNull(guiWinner.buttonExit);
        assertEquals("EXIT", guiWinner.buttonExit.getText());
        assertEquals(new Rectangle(910, 600, 200, 60), guiWinner.buttonExit.getBounds());
    }

}

