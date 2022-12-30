package DataStructure;

import Exceptions.InvalidCoordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void constructorTest() {
        try {
            new Board(5, 10);
        } catch (Exception e) {
            fail("Should not throw an exception.");
        }
    }

    @Test
    public void constructorInvalidHeightTest() {
        try {
            new Board(0, 10);
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void constructorInvalidWidthTest() {
        try {
            new Board(5, 0);
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getFieldTest() {
        Board testBoard;
        try {
            testBoard = new Board(5, 10);
            testBoard.getField(5, 10);
        } catch (Exception e) {
            fail("Should not throw an exception.");
        }
    }

    @Test
    public void getFieldInvalidXTest1() {
        Board testBoard;
        try {
            testBoard = new Board(5, 10);
            testBoard.getField(7, 10);
        } catch (InvalidCoordinate e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getFieldInvalidYTest1() {
        Board testBoard;
        try {
            testBoard = new Board(5, 10);
            testBoard.getField(5, 11);
        } catch (InvalidCoordinate e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getFieldInvalidXTest2() {
        Board testBoard;
        try {
            testBoard = new Board(5, 10);
            testBoard.getField(0, 10);
        } catch (InvalidCoordinate e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getFieldInvalidYTest2() {
        Board testBoard;
        try {
            testBoard = new Board(5, 10);
            testBoard.getField(5, 0);
        } catch (InvalidCoordinate e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

        @Test
        public void setBoardChangeEnabledTest() throws InvalidCoordinate {

            Board board = new Board(3, 3);
            board.setBoardChangeEnabled(false);
            for (int x = 1; x <= board.width; x++) {
                for (int y = 1; y <= board.height; y++) {
                    Cell cell = board.getField(x, y);
                    assertFalse(cell.enabled);
                }
            }
            board.setBoardChangeEnabled(true);
            for (int x = 1; x <= board.width; x++) {
                for (int y = 1; y <= board.height; y++) {
                    Cell cell = board.getField(x, y);
                    assertTrue(cell.enabled);
                }
            }
        }
    }

