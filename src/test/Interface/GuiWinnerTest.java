package Interface;

import InterfaceHelpers.ButtonWinnerGui;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class GuiWinnerTest {

    @Test
    public void constructorTest() {
        GuiWinner guiWinner = new GuiWinner("Julius");
        assertNotNull(guiWinner.labelWin);
        assertEquals("CONGRATULATIONS", guiWinner.labelWin.getText());
        assertEquals(new Font("Papyrus", Font.BOLD, 60), guiWinner.labelWin.getFont());
        assertEquals(new Rectangle(120, 200, 1000, 100), guiWinner.labelWin.getBounds());

        assertNotNull(guiWinner.labelWin);
        assertEquals("Julius", guiWinner.labelWinner.getText());
        assertEquals(new Font("Papyrus", Font.BOLD, 80), guiWinner.labelWinner.getFont());
        assertNotNull(guiWinner.labelWinner);
        assertEquals("Julius", guiWinner.labelWinner.getText());
        assertEquals(new Font("Papyrus", Font.BOLD, 80), guiWinner.labelWinner.getFont());
        assertEquals(new Rectangle(240, 300, 1000, 100), guiWinner.labelWinner.getBounds());

        assertNotNull(guiWinner.buttonBackToBoard);
        assertEquals("Back to Board", guiWinner.buttonBackToBoard.getText());
        assertEquals(new Rectangle(280, 600, 200, 60), guiWinner.buttonBackToBoard.getBounds());

        assertNotNull(guiWinner.buttonExit);
        assertEquals("EXIT", guiWinner.buttonExit.getText());
        assertEquals(new Rectangle(910, 600, 200, 60), guiWinner.buttonExit.getBounds());
    }


    @Test
    public void actionPerformedTest () {
        GuiWinner guiWinner = new GuiWinner("Julius");
        guiWinner.buttonBackToBoard = new ButtonWinnerGui();
        guiWinner.buttonExit = new ButtonWinnerGui();
        guiWinner.buttonRestart = new ButtonWinnerGui();
        guiWinner.buttonNewGame = new ButtonWinnerGui();
        guiWinner.buttonBackToBoard.setText("Back to Board");
        guiWinner.buttonExit.setText("EXIT");
        guiWinner.buttonRestart.setText("RESTART");
        guiWinner.buttonNewGame.setText("NEW GAME");

        ActionEvent ebtb = new ActionEvent(guiWinner.buttonBackToBoard, ActionEvent.ACTION_PERFORMED, "");
        ActionEvent er = new ActionEvent(guiWinner.buttonRestart, ActionEvent.ACTION_PERFORMED, "");
        ActionEvent eng = new ActionEvent(guiWinner.buttonNewGame, ActionEvent.ACTION_PERFORMED, "");

        guiWinner.actionPerformed(ebtb);
        assertFalse(guiWinner.isVisible());

        guiWinner.actionPerformed(er);
        assertFalse(guiWinner.isVisible());

       guiWinner.actionPerformed(eng);
       assertFalse(guiWinner.isVisible());
    }

    }



