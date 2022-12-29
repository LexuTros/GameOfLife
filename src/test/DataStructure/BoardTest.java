package DataStructure;

import Exceptions.InvalidCoordinate;
import Exceptions.InvalidHeight;
import Exceptions.InvalidWidth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class BoardTest {

    @Test
    public void constructorTest() {
        try {
            Board testBoard = new Board(5, 10);
        } catch (Exception e) {
            fail("Should not throw an exception.");
        }
    }

    @Test
    public void constructorInvalidHeightTest() throws InvalidWidth {
        try {
            Board testBoard = new Board(0, 10);
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void constructorInvalidWidthTest() throws InvalidHeight {
        try {
            Board testBoard = new Board(5, 0);
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }

    @Test
    public void getFieldTest() {
        Board testBoard;
        try {
            testBoard = new Board(5, 10);
            Cell testField = testBoard.getField(5, 10);
        } catch (Exception e) {
            fail("Should not throw an exception.");
        }
    }

    @Test
    public void getFieldInvalidXTest1() {
        Board testBoard;
        try {
            testBoard = new Board(5, 10);
            Cell testField = testBoard.getField(7, 10);
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
            Cell testField = testBoard.getField(5, 11);
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
            Cell testField = testBoard.getField(0, 10);
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
            Cell testField = testBoard.getField(5, 0);
        } catch (InvalidCoordinate e) {
            // All good here, expected exception
        } catch (Exception e) {
            fail("Different exception wrongly thrown.");
        }
    }
}
