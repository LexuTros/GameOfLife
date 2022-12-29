package Logic;

import DataStructure.Board;
import DataStructure.Player;
import Exceptions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static Logic.Round.simulateGeneration;
import static org.junit.jupiter.api.Assertions.*;

public class RoundTest {

    Board board = new Board(10, 10);
    Player playerOne = new Player("One", Color.GREEN);
    Player playerTwo = new Player("Two", Color.BLUE);

    public RoundTest() throws InvalidHeight, InvalidWidth {
    }

    @Test
    public void simulateGenerationCorrectReproductionIsAliveTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        board.getField(1,1).reviveCell(playerOne);
        board.getField(1,2).reviveCell(playerOne);
        board.getField(2,1).reviveCell(playerTwo);

        simulateGeneration(board);

        assertTrue(board.getField(2,2).getIsAlive());
    }

    @Test
    public void simulateGenerationCorrectReproductionOwnerTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        board.getField(1,1).reviveCell(playerOne);
        board.getField(1,2).reviveCell(playerTwo);
        board.getField(2,1).reviveCell(playerTwo);

        simulateGeneration(board);

        assertEquals(playerTwo, board.getField(2,2).getPlayer());
    }

    @Test
    public void simulateGenerationNoReproductionIsAliveTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        board.getField(1,1).reviveCell(playerOne);
        board.getField(2,1).reviveCell(playerTwo);

        simulateGeneration(board);

        assertFalse(board.getField(3,1).getIsAlive());
        assertFalse(board.getField(1,2).getIsAlive());
        assertFalse(board.getField(2,2).getIsAlive());
        assertFalse(board.getField(3,2).getIsAlive());
    }

    @Test
    public void simulateGenerationUnderpopulationDeathTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        board.getField(1,1).reviveCell(playerOne);
        board.getField(2,1).reviveCell(playerTwo);

        simulateGeneration(board);

        assertFalse(board.getField(1,1).getIsAlive());
        assertFalse(board.getField(2,1).getIsAlive());

    }

    @Test
    public void simulateGenerationOverpopulationDeathTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        board.getField(1,2).reviveCell(playerOne);

        board.getField(2,1).reviveCell(playerOne);

        board.getField(2,2).reviveCell(playerOne);

        board.getField(2,3).reviveCell(playerOne);

        board.getField(3,2).reviveCell(playerOne);

        simulateGeneration(board);

        assertFalse(board.getField(2,2).getIsAlive());

    }

    @Test
    public void simulateGenerationPopulationMaintenanceTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        board.getField(1,1).reviveCell(playerOne);
        board.getField(2,1).reviveCell(playerTwo);
        board.getField(1,2).reviveCell(playerOne);
        board.getField(2,2).reviveCell(playerTwo);

        simulateGeneration(board);

        assertTrue(board.getField(1,1).getIsAlive());
        assertTrue(board.getField(2,1).getIsAlive());
        assertTrue(board.getField(1,2).getIsAlive());
        assertTrue(board.getField(2,2).getIsAlive());

        simulateGeneration(board);

        assertTrue(board.getField(1,1).getIsAlive());
        assertTrue(board.getField(2,1).getIsAlive());
        assertTrue(board.getField(1,2).getIsAlive());
        assertTrue(board.getField(2,2).getIsAlive());
    }
}
