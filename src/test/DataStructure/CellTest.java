package DataStructure;

import Exceptions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

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
        testCell.setIsAlive(true);
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

}