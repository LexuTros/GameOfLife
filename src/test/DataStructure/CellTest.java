package DataStructure;

import Exceptions.*;
import Interface.GuiGame;
import Logic.Gameplay;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    public void getIsAliveTest() {
        Cell testCell = new Cell();
        assertFalse(testCell.getIsAlive());
    }

    @Test
    public void setIsAliveTest() {
        Cell testCell = new Cell();
        testCell.reviveCell(new Player("Günter", Color.green));
        assertTrue(testCell.getIsAlive());
    }

    @Test
    public void getPlayerNoPlayerAssignedTest() {
        Cell testCell = new Cell();
        try {
            testCell.getPlayer();
        } catch (NoPlayerAssigned e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getPlayerPlayerAssignedTest() {
        Player marsh = new Player("Marsh", Color.GREEN);
        Cell testCell = new Cell();
        testCell.setPlayer(marsh);
        String actual = "Wrong";
        try {
            actual = testCell.getPlayer().getPlayerName();
        } catch (Exception e) {
            fail("Should not throw an exception.");
        }
        assertEquals("Marsh", actual);
    }

    @Test
    public void getRoundChangedNewCellTest() {
        Cell testCell = new Cell();
        try {
            testCell.getRoundChanged();
        } catch (NotYetChanged e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void setRoundChangedTest() {
        Cell testCell = new Cell();
        int actual = -1;
        try {
            testCell.setRoundChanged(3);
            actual = testCell.getRoundChanged();
        } catch (Exception e) {
            fail("Should not throw an exception.");
        }
        assertEquals(3, actual);
    }

    @Test
    public void setNegativeOrZeroRoundChangedTest() {
        Cell testCell = new Cell();
        try {
            testCell.setRoundChanged(0);
        } catch (InvalidRound e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getAliveNeighborsTest() {
        Cell testCell = new Cell();
        assertEquals(0, testCell.getAliveNeighbors());
    }

    @Test
    public void setAliveNeighborsTest() {
        Cell testCell = new Cell();
        try {
            testCell.setAliveNeighbors(8);
        } catch (Exception e) {
            fail("Should not throw an exception.");
        }
        assertEquals(8, testCell.getAliveNeighbors());
    }

    @Test
    public void setTooManyAliveNeighborsTest() {
        Cell testCell = new Cell();
        try {
            testCell.setAliveNeighbors(10);
        } catch (TooManyAliveNeighbors e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void setNegativeAliveNeighborsTest() {
        Cell testCell = new Cell();
        try {
            testCell.setAliveNeighbors(-1);
        } catch (NegativeAmountOfNeighbors e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void setEnabledChangeTest() {
        Cell testCell = new Cell();
        testCell.setEnabledChange(true);
        assertTrue(testCell.isEnabled());
    }

    @Test
    public void actionPerformedItemRestartTest() {
        Board board = new Board(50,50);
        Player p1 = new Player("Chris", Color.GREEN);
        Player p2 = new Player("Valentin", Color.RED);
        GuiGame gui = new GuiGame(board, p1, p2);
        assertTrue(gui.isVisible());
    }

    @Test
    public void actionPerformedItemNewGameTest() {
        Board board = new Board(50,50);
        Player p1 = new Player("Philipp", Color.PINK);
        Player p2 = new Player("Karl", Color.GREEN);
        GuiGame gui = new GuiGame(board, p1, p2);
        JMenuItem itemNewGame = gui.itemNewGame;

        ActionEvent event = new ActionEvent(itemNewGame, ActionEvent.ACTION_PERFORMED, null);
        gui.actionPerformed(event);
        assertFalse(gui.isVisible());
    }

    @Test
    public void mousePressedNotEnabledTest() {
        Cell testCell = new Cell();
        testCell.setEnabledChange(false);
        testCell.reviveCell(new Player("Karl", Color.RED));
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        testCell.mousePressed(event);
        assertTrue(testCell.getIsAlive());

    }

    @Test
    public void mousePressedFirstConditionTrueTest() {
        Cell testCell = new Cell();
        Player sazed = new Player("Sazed", Color.RED);
        Player marsh = new Player("Marsh", Color.RED);
        Board board = new Board(50,37);
        new GuiGame(board, sazed, marsh);
        Gameplay.setToCreate(true);
        Gameplay.setActivePlayer(sazed);
        testCell.setFuturePlayer(sazed);
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        testCell.mousePressed(event);
        assertFalse(Gameplay.getToCreate());
    }

    @Test
    public void mousePressedSecondConditionTrueTest() {
        Cell testCell = new Cell();
        Player sazed = new Player("Sazed", Color.RED);
        Player marsh = new Player("Marsh", Color.RED);
        Board board = new Board(50,37);
        new GuiGame(board, sazed, marsh);
        Gameplay.setActivePlayer(sazed);
        testCell.reviveCell(sazed);
        Gameplay.setGeneration(1);
        try {
            testCell.setRoundChanged(1);
        } catch (Exception e) {
            // should not throw exception
        }
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        testCell.mousePressed(event);
        assertTrue(Gameplay.getToCreate());
    }

    @Test
    public void mousePressedThirdConditionTrueTest() {
        Cell testCell = new Cell();
        Player sazed = new Player("Sazed", Color.RED);
        Player marsh = new Player("Marsh", Color.RED);
        Board board = new Board(50,37);
        new GuiGame(board, sazed, marsh);
        Gameplay.setToCreate(true);
        Gameplay.setActivePlayer(sazed);
        Gameplay.setToKill(true);
        testCell.reviveCell(marsh);
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        testCell.mousePressed(event);
        assertFalse(Gameplay.getToKill());
    }

    @Test
    public void mouseClickedTest() {
        Cell testCell = new Cell();
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 0, false);
        testCell.mouseClicked(event);
        assertTrue(true);
    }
    @Test
    public void mouseReleasedTest() {
        Cell testCell = new Cell();
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_RELEASED,
                System.currentTimeMillis(), 0, 0, 0, 0, false);
        testCell.mouseReleased(event);
        assertTrue(true);
    }

    @Test
    public void mouseExitedTest() {
        Cell testCell = new Cell();
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_EXITED,
                System.currentTimeMillis(), 0, 0, 0, 0, false);
        testCell.mouseExited(event);
        assertTrue(true);
    }

    @Test
    public void mouseEnteredTest() {
        Cell testCell = new Cell();
        MouseEvent event = new MouseEvent(testCell, MouseEvent.MOUSE_ENTERED,
                System.currentTimeMillis(), 0, 0, 0, 0, false);
        testCell.mouseEntered(event);
        assertTrue(true);
    }


    @Test
    public void getFuturePlayerTest() {
        Cell testCell = new Cell();
        try {
            testCell.getFuturePlayer();
        } catch (NoPlayerAssigned e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getFuturePlayerInvalidTest() {
        Cell testCell = new Cell();
        assertThrows(NoPlayerAssigned.class, testCell::getFuturePlayer);
    }

}