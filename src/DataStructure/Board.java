package DataStructure;

import Exceptions.InvalidCoordinate;
import Exceptions.InvalidHeight;
import Exceptions.InvalidWidth;

public class Board {
    final Cell[][] board;

    public Board(int height, int width) throws InvalidHeight, InvalidWidth {
        if (height < 1) {
            throw new InvalidHeight();
        } else if (width < 1) {
            throw new InvalidWidth();
        } else {
            board = new Cell[height][width];
            initializeBoard();
        }
    }

    private void initializeBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    public Cell getField(int xCoordinate, int yCoordinate) throws InvalidCoordinate {
        xCoordinate--;
        yCoordinate--;
        if (xCoordinate < 0 ||
                yCoordinate < 0 ||
                xCoordinate >= board.length ||
                yCoordinate >= board[0].length) {
            throw new InvalidCoordinate();
        }
        return board[xCoordinate][yCoordinate];
    }
}
