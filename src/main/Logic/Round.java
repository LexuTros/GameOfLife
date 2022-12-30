package Logic;

import DataStructure.Board;
import DataStructure.Cell;
import DataStructure.Player;
import Exceptions.InvalidCoordinate;
import Exceptions.NegativeAmountOfNeighbors;
import Exceptions.NoPlayerAssigned;
import Exceptions.TooManyAliveNeighbors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {

    private static void determineCellFuture(Board board, int xCoordinate, int yCoordinate) throws InvalidCoordinate, NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        Cell currentCell = board.getField(xCoordinate, yCoordinate);
        int neighborCounter = 0;
        List<Player> aliveNeighborOwners = new ArrayList<>();

        // count alive neighbors
        for (int x = xCoordinate - 1; x <= xCoordinate + 1; x++){
            for (int y = yCoordinate - 1; y <= yCoordinate + 1; y++) {
                if (x != xCoordinate || y != yCoordinate) {
                    try{
                        Cell neighborCell = board.getField(x,y);
                        if (neighborCell.getIsAlive()) {
                            neighborCounter++;
                            aliveNeighborOwners.add(neighborCell.getPlayer());
                        }
                    }
                    catch (InvalidCoordinate ignored){}
                }
            }
        }
        currentCell.setAliveNeighbors(neighborCounter);

        // set the owner of the cell if it will turn alive
        if (!currentCell.getIsAlive() && neighborCounter == 3) {
            for (Player neighborOwner : aliveNeighborOwners) {
                if (Collections.frequency(aliveNeighborOwners, neighborOwner) >= 2) {
                    currentCell.setFuturePlayer(neighborOwner);
                    return;
                }
            }
        }
    }



    private static void progressCell(Cell cell) throws NoPlayerAssigned {
        int neighbors = cell.getAliveNeighbors();
        if (cell.getIsAlive()) {
            if (neighbors < 2 || neighbors > 3) {
                cell.killCell();
            }
        } else {
            if (neighbors == 3) {
                cell.reviveCell(cell.getFuturePlayer());
            }
        }
    }

    public static void simulateGeneration(Board board) throws NoPlayerAssigned, TooManyAliveNeighbors, NegativeAmountOfNeighbors, InvalidCoordinate {
        for (int x = 1; x <= board.width; x++) {
            for (int y = 1; y <= board.height; y++) {
                determineCellFuture(board, x, y);
            }
        }
        for (int x = 1; x <= board.width; x++) {
            for (int y = 1; y <= board.height; y++) {
                progressCell(board.getField(x, y));
            }
        }
    }
}
