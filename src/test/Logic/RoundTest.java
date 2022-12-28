package Logic;

import DataStructure.Board;
import DataStructure.Player;
import Exceptions.*;
import org.junit.jupiter.api.Test;

import static Logic.Round.simulateGeneration;
import static org.junit.jupiter.api.Assertions.*;

public class RoundTest {
//
//    Board board = new Board(10, 10);
//    Player playerOne = new Player("One", "green");
//    Player playerTwo = new Player("Two", "blue");
//
//    public RoundTest() throws InvalidHeight, InvalidWidth {
//    }
//
//    @Test
//    public void simulateGenerationCorrectReproductionIsAliveTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
//        board.getField(1,1).setIsAlive(true);
//        board.getField(1,1).setPlayer(playerOne);
//        board.getField(1,2).setIsAlive(true);
//        board.getField(1,2).setPlayer(playerOne);
//        board.getField(2,1).setIsAlive(true);
//        board.getField(2,1).setPlayer(playerTwo);
//
//        simulateGeneration(board);
//
//        assertTrue(board.getField(2,2).getIsAlive());
//    }
//
//    @Test
//    public void simulateGenerationCorrectReproductionOwnerTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
//        board.getField(1,1).setIsAlive(true);
//        board.getField(1,1).setPlayer(playerOne);
//        board.getField(1,2).setIsAlive(true);
//        board.getField(1,2).setPlayer(playerTwo);
//        board.getField(2,1).setIsAlive(true);
//        board.getField(2,1).setPlayer(playerTwo);
//
//        simulateGeneration(board);
//
//        assertEquals(playerTwo, board.getField(2,2).getPlayer());
//    }
//
//    @Test
//    public void simulateGenerationNoReproductionIsAliveTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
//        board.getField(1,1).setIsAlive(true);
//        board.getField(1,1).setPlayer(playerOne);
//        board.getField(2,1).setIsAlive(true);
//        board.getField(2,1).setPlayer(playerTwo);
//
//        simulateGeneration(board);
//
//        assertFalse(board.getField(3,1).getIsAlive());
//        assertFalse(board.getField(1,2).getIsAlive());
//        assertFalse(board.getField(2,2).getIsAlive());
//        assertFalse(board.getField(3,2).getIsAlive());
//    }
//
//    @Test
//    public void simulateGenerationUnderpopulationDeathTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
//        board.getField(1,1).setIsAlive(true);
//        board.getField(1,1).setPlayer(playerOne);
//        board.getField(2,1).setIsAlive(true);
//        board.getField(2,1).setPlayer(playerTwo);
//
//        simulateGeneration(board);
//
//        assertFalse(board.getField(1,1).getIsAlive());
//        assertFalse(board.getField(2,1).getIsAlive());
//
//    }
//
//    @Test
//    public void simulateGenerationOverpopulationDeathTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
//        board.getField(1,2).setIsAlive(true);
//        board.getField(1,2).setPlayer(playerOne);
//
//        board.getField(2,1).setIsAlive(true);
//        board.getField(2,1).setPlayer(playerOne);
//
//        board.getField(2,2).setIsAlive(true);
//        board.getField(2,2).setPlayer(playerOne);
//
//        board.getField(2,3).setIsAlive(true);
//        board.getField(2,3).setPlayer(playerOne);
//
//        board.getField(3,2).setIsAlive(true);
//        board.getField(3,2).setPlayer(playerOne);
//
//        simulateGeneration(board);
//
//        assertFalse(board.getField(2,2).getIsAlive());
//
//    }
//
//    @Test
//    public void simulateGenerationPopulationMaintenanceTest() throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
//        board.getField(1,1).setIsAlive(true);
//        board.getField(1,1).setPlayer(playerOne);
//        board.getField(2,1).setIsAlive(true);
//        board.getField(2,1).setPlayer(playerTwo);
//        board.getField(1,2).setIsAlive(true);
//        board.getField(1,2).setPlayer(playerOne);
//        board.getField(2,2).setIsAlive(true);
//        board.getField(2,2).setPlayer(playerTwo);
//
//        simulateGeneration(board);
//
//        assertTrue(board.getField(1,1).getIsAlive());
//        assertTrue(board.getField(2,1).getIsAlive());
//        assertTrue(board.getField(1,2).getIsAlive());
//        assertTrue(board.getField(2,2).getIsAlive());
//
//        simulateGeneration(board);
//
//        assertTrue(board.getField(1,1).getIsAlive());
//        assertTrue(board.getField(2,1).getIsAlive());
//        assertTrue(board.getField(1,2).getIsAlive());
//        assertTrue(board.getField(2,2).getIsAlive());
//    }
}
